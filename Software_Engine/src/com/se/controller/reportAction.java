package com.se.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.report;
import com.se.util.JDBCUtil;

public class reportAction extends ActionSupport {
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
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from report where student=? and expid=? ;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stu_id);
		pstmt.setInt(2, expid);
		ResultSet rs = pstmt.executeQuery();
		report r=new report();
		while(rs.next())
		{
			r.setId(rs.getInt("id"));
			r.setTime(rs.getDate("time"));
			r.setTitle(rs.getString("title"));
			r.setContent(rs.getString("content"));
			r.setScore(rs.getInt("score"));
		}
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("report",r);
		return "report";
	}
	
	
	public String addreport() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO report(student,title,content,score,expid,time) VALUES (?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stu_id);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setDouble(4, -1);
		pstmt.setInt(5, expid);
		Date now = new Date(System.currentTimeMillis()); 
		pstmt.setDate(6, now);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
		
		sql="UPDATE report SET content = REPLACE(content, '\\r\\n', '<br/>')";
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		return "showreport";
	}
	
	

}
