package com.se.controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.se.service.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.Student;
import com.se.domain.teach_prog;
import com.se.util.JDBCUtil;
import com.se.dao.*;

public class teachAction extends ActionSupport {
	private String title;
	private String content;
	
	private TeacherServiceImpl teacherser = new TeacherServiceImpl();
	private TeacherDaoJDBCImpl teacherdao= new TeacherDaoJDBCImpl();
	
	public int getDeleteid() {
		return deleteid;
	}
	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
	private int deleteid;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	private int year;
	public String teach_stu() throws SQLException
	{
		List funds = new ArrayList<teach_prog>();
		funds=teacherser.teach();
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("teachList", funds);// step 3
		return "stu";
	}
	
	public String teach() throws SQLException
	{
		List funds = new ArrayList<teach_prog>();
		funds=teacherser.teach();
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("teachList", funds);// step 3
		return SUCCESS;
	}
	
	public String addteach() throws SQLException
	{
		teacherdao.add(title, content, year);
		return SUCCESS;
	}
	public String deleteteach() throws SQLException
	{
		teacherdao.delete(deleteid);
		return SUCCESS;
	}
}
