package com.se.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.se.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.report;
import com.se.util.JDBCUtil;

public class reportAction extends ActionSupport {
	private ReportDaoJDBCImpl reportdao = new ReportDaoJDBCImpl();
	private int stu_id;
	private int expid;
	private String title;
	private String content;
	public int getExpid() {
		return expid;
	}
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
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String show_report() throws SQLException
	{
		report r=reportdao.getreport(stu_id, expid);
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("report",r);
		return "report";
	}
	
	
	public String addreport() throws SQLException
	{
		reportdao.submit(stu_id, title, content, expid);
		return "showreport";
	}
	
	

}
