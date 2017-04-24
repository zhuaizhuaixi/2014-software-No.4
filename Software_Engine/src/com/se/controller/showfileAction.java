package com.se.controller;

import java.io.File;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class showfileAction extends ActionSupport {
	
	public String showfile()
	{
		String str;
		ActionContext ctx = ActionContext.getContext();
		Map request=(Map)ctx.get("request");
		String path=ServletActionContext.getServletContext().getRealPath("\\upload\\");
		  File file=new File(path);
		  String[] filelist = new String[100];
		  File[] tempList = file.listFiles();
<<<<<<< HEAD
		  System.out.println("一共有"+tempList.length);
=======
		  System.out.println("璇ョ洰褰曚笅瀵硅薄涓暟锛�"+tempList.length);
>>>>>>> origin/struts2
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
<<<<<<< HEAD
		    System.out.println("在"+str);
=======
		    System.out.println("鏂�     浠讹細"+str);
>>>>>>> origin/struts2
		   }
		  }
		  System.out.println(path);
		  request.put("list",filelist);
		System.out.println(path);
		  
		  return SUCCESS;
	}
	
	public String showfile_stu()
	{
		String str;
		ActionContext ctx = ActionContext.getContext();
		Map request=(Map)ctx.get("request");
		String path=ServletActionContext.getServletContext().getRealPath("\\upload\\");
		  File file=new File(path);
		  String[] filelist = new String[100];
		  File[] tempList = file.listFiles();
		  System.out.println("一共有"+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
		    System.out.println("在"+str);
		   }
		  }
		  System.out.println(path);
		  request.put("list",filelist);
		System.out.println(path);
		  
		  return "stu";
	}
	public showfileAction() {
		// TODO Auto-generated constructor stub
	}

}
