package org.fornax.cartridges.sculptor.smartclient.server;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class UploadServlet implements HttpRequestHandler {
	private static final Logger log=Logger.getLogger(UploadServlet.class.getName());
	private static final String errText="Request isn't multipart. Set enctype='multipart/form-data' on your form.";
	private static final String FILE_UPLOAD_CACHE="fileupload";

	@SuppressWarnings("unchecked")
	public void handleRequest(HttpServletRequest req, HttpServletResponse repl) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getContentType() != null && item.getSize() > 0) {
						putFileItem(req, item);
						log.log(Level.WARNING, "Get file "+item.getName()
								+" :: contentType="+item.getContentType()
								+" :: fieldName="+item.getFieldName()
								+" :: size="+item.getSize());
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {			
			log.log(Level.WARNING, errText);
			repl.getWriter().write(errText);
			repl.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	public FileItem getFileItem(String sessionId, String fieldName, String fileName) {
		File f=new File(fileName);
		String elemName=sessionId+"#"+fieldName+"#"+f.getName();
		Element fileElement = getFileUploadCache().get(elemName);
		if (fileElement==null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// Ignore error
			}
			fileElement = getFileUploadCache().get(elemName);
		}

		return fileElement == null ? null : (FileItem) fileElement.getObjectValue();
	}

	public void putFileItem(HttpServletRequest req, FileItem fileItem) {
		String elemName=req.getSession().getId()+"#"+fileItem.getFieldName()+"#"+fileItem.getName();
		Element elem=new Element(elemName, fileItem);
		getFileUploadCache().put(elem);
	}

	static Ehcache fileUploadCache=null;
	private Ehcache getFileUploadCache() {
		if (fileUploadCache==null) {
			CacheManager.create().addCache(FILE_UPLOAD_CACHE);
			fileUploadCache=CacheManager.create().getEhcache(FILE_UPLOAD_CACHE);
		}
		return fileUploadCache;
	}
}
