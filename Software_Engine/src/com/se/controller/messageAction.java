package com.se.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.service.MessageServiceImpl;
import com.se.service.StudentServiceImpl;
import com.se.util.JDBCUtil;
import com.se.util.PageBean;

public class messageAction extends ActionSupport {
	private int pageNo=1;
	private String msg;
	private int msgerid;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getMsgerid() {
		return msgerid;
	}
	public void setMsgerid(int msgerid) {
		this.msgerid = msgerid;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String show()
	{
		MessageServiceImpl messageService=new MessageServiceImpl();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		PageBean pageBean = messageService.getMessages(pageNo); // step 2
		request.put("messageList", pageBean);// step 3	
		return SUCCESS;
	}
	public String show_stu()
	{
		MessageServiceImpl messageService=new MessageServiceImpl();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		PageBean pageBean = messageService.getMessages(pageNo); // step 2
		request.put("messageList", pageBean);// step 3	
		return "stu";
	}
	public String submit() throws SQLException
	{
		MessageServiceImpl messer = new MessageServiceImpl();
		messer.insertmessage(msg, msgerid);
		return "show";
	}
	public String submit_stu() throws SQLException
	{
		MessageServiceImpl messer = new MessageServiceImpl();
		messer.insertmessage(msg, msgerid);
		return "show_stu";
	}
}
