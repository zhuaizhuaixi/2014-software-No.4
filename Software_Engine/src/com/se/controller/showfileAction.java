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
		  System.out.println("该目录下对象个数："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
			   str=tempList[i].toString();
			   str=str.replace(path+"\\", "");
			   filelist[i]=str;
		    System.out.println("文     件："+str);
		   }
		  }
		  
		  request.put("list",filelist);
		  return SUCCESS;
	}
	public showfileAction() {
		// TODO Auto-generated constructor stub
	}

}