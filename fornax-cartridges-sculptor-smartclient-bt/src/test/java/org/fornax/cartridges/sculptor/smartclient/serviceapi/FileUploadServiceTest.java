package org.fornax.cartridges.sculptor.smartclient.serviceapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.fornax.cartridges.sculptor.framework.domain.PagingParameter;
import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.fornax.cartridges.sculptor.smartclient.domain.FileUpload;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
@Ignore
//TODO Ignore due to Could not autowire field: private org.springframework.security.providers.encoding.PasswordEncoder
public class FileUploadServiceTest extends AbstractDbUnitJpaTests implements FileUploadServiceTestBase {
	private FileUploadService fileUploadService;

	@Autowired
	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@Test
	public void testFindAll() throws Exception {
		uploadFile();
		uploadFile();
		List<FileUpload> all = fileUploadService.findAll(getServiceContext(), PagingParameter.noLimits()).getValues();
		Assert.assertEquals(2, all.size());

		Assert.assertEquals(Long.valueOf(originSize), all.get(0).getFileLength());
		Assert.assertEquals(simulatedFileName, all.get(0).getOriginalFileName());

		Assert.assertEquals(Long.valueOf(originSize), all.get(1).getFileLength());
		Assert.assertEquals(simulatedFileName, all.get(1).getOriginalFileName());
	}

	@Test
	public void testFindById() throws Exception {
		uploadFile();
		List<FileUpload> all = fileUploadService.findAll(getServiceContext(), PagingParameter.noLimits()).getValues();
		Assert.assertEquals(1, all.size());

		FileUpload fileUpload = fileUploadService.findById(getServiceContext(), all.get(0).getId());
		Assert.assertEquals(Long.valueOf(originSize), fileUpload.getFileLength());
		Assert.assertEquals(simulatedFileName, fileUpload.getOriginalFileName());
	}

	@Test
	public void testUploadFile() throws Exception {
		FileUpload uploadFile = uploadFile();
		Assert.assertEquals(Long.valueOf(originSize), uploadFile.getFileLength());
		Assert.assertEquals(simulatedFileName, uploadFile.getOriginalFileName());

		File repositoryFile=new File(repositoryLocation+"/"+uploadFile.getLocalName());
		Assert.assertTrue(repositoryFile.exists());
		Assert.assertEquals(originSize, repositoryFile.length());
	}

	@Test
	public void testDownloadFile() throws Exception {
		FileUpload uploadFile = uploadFile();
		InputStream downloadFile = fileUploadService.downloadFile(getServiceContext(), uploadFile);

		long totalLength=0;
		byte[] buffer=new byte[3333];
		for (int length; (length = downloadFile.read(buffer)) != -1;) {
			totalLength+=length;
		}
		Assert.assertEquals(originSize, totalLength);
	}

	String originFilePath="src/test/resources/importExample/PUBFullInfo20090921103116.xls";
	long originSize=55296L;
	String simulatedFileName="index.xls";
	String repositoryLocation=System.getProperty("java.io.tmpdir");

	private FileUpload uploadFile() throws Exception {
		FileInputStream file=new FileInputStream(originFilePath);
		return fileUploadService.uploadFile(getServiceContext(), simulatedFileName, "application/octet-stream", file);
	}

	public void testFindByCondition() throws Exception {
	   // TODO Auto-generated method stub
	   
   }
}
