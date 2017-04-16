package com.se.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction extends ActionSupport {
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String upload() throws Exception
	{
		FileOutputStream fos=new FileOutputStream(ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte [] buffer = new byte[1024];
		int len=0;
//		System.out.println(ServletActionContext.getServletContext().getRealPath(savePath));
		while((len=fis.read(buffer))>0)
			fos.write(buffer, 0, len);
		return SUCCESS;
	}
	public uploadAction() {
		// TODO Auto-generated constructor stub
	}

}
