package com.se.controller;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import com.se.service.*;
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
		FileServiceImpl fileser = new FileServiceImpl();
		fileser.delete(fileName);
		return SUCCESS;
	}

	public deletefileAction() {
		// TODO Auto-generated constructor stub
	}

}
