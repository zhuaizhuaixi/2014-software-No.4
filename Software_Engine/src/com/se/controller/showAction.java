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
		StudentService fundService=new StudentServiceImpl();
		ActionContext ctx = ActionContext.getContext();
//		int pageNo=1;
		Map request = (Map)ctx.get("request");
//		if(request.get("pageNo")!=null)
	//		pageNo=Integer.parseInt((String)request.get("pageNo"));
		//List<Fund> funds = fundDao.findAll(); // step 2
		PageBean pageBean = fundService.getFunds(pageNo); // step 2
		request.put("studentList", pageBean);// step 3
		
		return SUCCESS;
	}
	public showAction() {
		// TODO Auto-generated constructor stub
	}

}
