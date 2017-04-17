package com.se.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{
    InputStream fileInputStream;
    String fileName;


	public String execute() throws UnsupportedEncodingException
    {
    	String path=ServletActionContext.getServletContext().getRealPath("\\upload\\");
    	
    	
    	String str;                           //获取文件夹中文件名的数组
    	  File file2=new File(path);
		  String[] filelist = new String[100];
		  File[] tempList = file2.listFiles();
		  System.out.println("该目录下对象个数："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
		    System.out.println("文     件："+str);
		   }
		  }
    	
		  File file=new File(path+"\\"+filelist[Integer.parseInt(fileName)]);
    	System.out.println(path+"\\"+filelist[Integer.parseInt(fileName)]);
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