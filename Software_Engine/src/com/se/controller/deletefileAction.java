package com.se.controller;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class deletefileAction extends ActionSupport {
	private int fileName;
	public int getFileName() {
		return fileName;
	}

	public void setFileName(int fileName) {
		this.fileName = fileName;
	}

	public String deletefile()
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
		return SUCCESS;
	}

	public deletefileAction() {
		// TODO Auto-generated constructor stub
	}

}
