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
import com.se.service.MessageService;
import com.se.service.MessageServiceImpl;
import com.se.service.StudentService;
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
		MessageService messageService=new MessageServiceImpl();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		PageBean pageBean = messageService.getMessages(pageNo); // step 2
		request.put("messageList", pageBean);// step 3	
		return SUCCESS;
	}
	public String show_stu()
	{
		MessageService messageService=new MessageServiceImpl();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		PageBean pageBean = messageService.getMessages(pageNo); // step 2
		request.put("messageList", pageBean);// step 3	
		return "stu";
	}
	public String submit() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO message_board(content,author,time) VALUES (?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  msg);
		pstmt.setInt(2, msgerid);
		java.util.Date date=new java.util.Date();
		Timestamp tt=new Timestamp(date.getTime());
		pstmt.setTimestamp(3, tt);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
		return "show";
	}
	public String submit_stu() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO message_board(content,author,time) VALUES (?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  msg);
		pstmt.setInt(2, msgerid);
		java.util.Date date=new java.util.Date();
		Timestamp tt=new Timestamp(date.getTime());
		pstmt.setTimestamp(3, tt);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
		return "show_stu";
	}
}
