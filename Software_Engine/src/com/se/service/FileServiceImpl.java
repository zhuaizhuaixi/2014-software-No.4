package com.se.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

public class FileServiceImpl {

	public void delete(int fileName)
	{
		String str;
		String path=ServletActionContext.getServletContext().getRealPath("\\upload\\");
		File file2=new File(path);
		  String[] filelist = new String[100];
		  File[] tempList = file2.listFiles();
		  System.out.println("共有"+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
		    System.out.println("是"+str);
		   }
		  }
		  File file=new File(path+"\\"+filelist[fileName]);
		  System.out.println(file.toString());
		file.delete();
	}
	
	public File download(InputStream fileInputStream,String fileName) throws UnsupportedEncodingException
	{
String path=ServletActionContext.getServletContext().getRealPath("\\upload\\");
    	
    	String str;                           
    	  File file2=new File(path);
		  String[] filelist = new String[100];
		  File[] tempList = file2.listFiles();
		  System.out.println("共有"+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
		    System.out.println("是"+str);
		   }
		  }
    	
		  File file=new File(path+"\\"+filelist[Integer.parseInt(fileName)]);
    	System.out.println(path+"\\"+filelist[Integer.parseInt(fileName)]);
    	return file;
	}
	
}
