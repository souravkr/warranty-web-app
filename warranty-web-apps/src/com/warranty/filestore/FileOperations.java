package com.warranty.filestore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileOperations {
	
	
	private static final String LOCATION = "Invoices";

	public void writeFile(CommonsMultipartFile file, HttpSession session, String filename) throws FileNotFoundException, IOException {
		ServletContext context = session.getServletContext();
		
		String path = context.getRealPath(LOCATION);
		
		System.out.println("filename = " + filename);	
		
		byte[] bytes = file.getBytes(); 
		
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	  
	    stream.write(bytes);    
	    
	    stream.flush();  
	    stream.close();
	
	}

}
