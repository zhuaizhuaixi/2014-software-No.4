package com.se.controller;

import com.se.service.*;
import com.se.util.PageBean;

import java.util.Map;

import com.se.service.StudentService;
import com.se.service.StudentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class showAction extends ActionSupport {
	private int pageNo=1;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String show()
	{
		StudentService studentService=new StudentServiceImpl();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		PageBean pageBean = studentService.getStudents(pageNo); // step 2
		request.put("studentList", pageBean);// step 3
		
		return SUCCESS;
	}
	public showAction() {
		// TODO Auto-generated constructor stub
	}

}
