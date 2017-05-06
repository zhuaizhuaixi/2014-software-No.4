package com.se.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.service.FileServiceImpl;

public class FileDownloadAction extends ActionSupport{
    InputStream fileInputStream;
    String fileName;


	public String execute() throws UnsupportedEncodingException
    {
		FileServiceImpl fileser = new FileServiceImpl();
		  File file=fileser.download(fileInputStream, fileName);
     	fileName=file.getName();
    	ServletActionContext.getResponse().setHeader("Content-Disposition","attachment;fileName="+java.net.URLEncoder.encode(fileName, "UTF-8"));
   	try {
   		
			fileInputStream=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return SUCCESS;
    }
	

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) throws UnsupportedEncodingException {
		this.fileName = fileName;
		this.fileName = new String(fileName.getBytes("ISO8859-1"), "utf-8");

	}
}