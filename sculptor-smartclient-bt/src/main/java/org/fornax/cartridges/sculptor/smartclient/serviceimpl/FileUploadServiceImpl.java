package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.smartclient.domain.AuditLog;
import org.fornax.cartridges.sculptor.smartclient.domain.FileUpload;
import org.springframework.stereotype.Service;

/**
 * Implementation of FileUploadService.
 */
@Service("fileUploadService")
public class FileUploadServiceImpl extends FileUploadServiceImplBase {
	private static final String FILE_STORAGE_PROPERTY = "file.storage.dir";
	private static boolean logged = false;

	public FileUpload uploadFile(@Name("ctx") ServiceContext ctx,
			@Name("fileName") String fileName,
			@Name("contentType") String contentType,
			@Name("fileHandle") InputStream fileHandle) {
		String dir=getUploadDirectory(ctx);

		FileUpload fileUpload = new FileUpload(UUID.randomUUID().toString());
		fileUpload.setOriginalFileName(fileName);
		fileUpload.setContentType(contentType);
		FileOutputStream output;
		try {
			output = new FileOutputStream(dir+"/"+fileUpload.getLocalName());
			long totalLength=0;
			byte[] byteBuffer=new byte[1024];
			for (int length=0; (length=fileHandle.read(byteBuffer)) != -1; totalLength+=length) {
				output.write(byteBuffer, 0, length);
			}
			fileUpload.setFileLength(totalLength);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Can't write file "+fileUpload.getLocalName()+" to repository "+dir);
		} finally {
			try {
				fileHandle.close();
			} catch (Throwable e) {
				// Ignore error
			}
		}

		return getFileUploadRepository().save(fileUpload);
	}

	public InputStream downloadFile(@Name("ctx") ServiceContext ctx, @Name("inputFile") FileUpload inputFile) {
		String dir=getUploadDirectory(ctx);
		File localFile=new File(dir+"/"+inputFile.getLocalName());
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(localFile);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			throw new IllegalArgumentException("File "+inputFile.getLocalName()+" isn't readable from repository "+dir);
		}

		return fis;
	}

	private String getUploadDirectory(ServiceContext ctx) {
		String dir=getPropertyService().getPropertyValue(ctx, null, FILE_STORAGE_PROPERTY, null);

		AuditLog log=new AuditLog();
		log.setService("FileUploadServiceImpl");
		log.setAction("uploadFile");
		log.setParam0(FILE_STORAGE_PROPERTY);

		if (dir == null) {
			dir = System.getProperty("user.home")+"/upload";
			log.setParam1(dir);
			File uploadDir=new File(dir);
			if (!uploadDir.exists()) {
				if (!uploadDir.mkdirs()) {
					throw new IllegalArgumentException("Can't create upload dir "+dir);
				}
			}
			if (!logged) {
				log.setLevel(org.fornax.cartridges.sculptor.smartclient.domain.AuditLevel.WARNING);
				log.setMsgNumber(3011);
				log.setDescription("Define property {0} which point to upload directory, defaulting to {1}");
				getAuditLogService().save(ctx, log);
			}
			logged=true;
		}

		File storage=new File(dir);
		if (! storage.isDirectory() || !storage.canWrite() || !storage.canRead()) {
			throw new IllegalArgumentException("Property "+FILE_STORAGE_PROPERTY+" have to point to"
					+ " directory which is readable and writable by app, current value is "+dir);
		}
		
		return dir;
	}
}
