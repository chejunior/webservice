package com.mike.jaxrs.attachments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

public class FileService {
	
	private static final String FILE_PATH = "/Users/michaeljcastro/Desktop/tibu.jpg";
	
	@POST
	@Path("/upload")
	public void upload(List<Attachment> attachments) throws IOException {
		for (Attachment attachment : attachments) {
			InputStream inputStream = attachment.getDataHandler().getInputStream();
			copyFile(inputStream);
		}
	}
	
	@GET
	@Path("/download")
	public Response download(){
		File file = new File (FILE_PATH);
		ResponseBuilder response = Response.ok(file);
		response.header("Content-Disposition", "atachment;filename=downloaded.jpg");
		
		return response.build();
	}
	
	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException{
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		
		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
			
		}
		out.flush();
		out.close();
	}

}
