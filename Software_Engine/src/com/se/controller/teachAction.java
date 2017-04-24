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
import com.se.domain.Student;
import com.se.domain.teach_prog;
import com.se.util.JDBCUtil;

public class teachAction extends ActionSupport {
	private String title;
	private String content;
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
<<<<<<< HEAD
	public String teach_stu() throws SQLException
	{
		List funds = new ArrayList<teach_prog>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from teaching_programme";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			teach_prog fund = new teach_prog();
			fund.setId(rs.getInt("id"));
			fund.setTitle(rs.getString("title"));
			fund.setContent(rs.getString("content"));
			fund.setYeaR(rs.getInt("year"));
			fund.setTime(rs.getDate("time"));
			funds.add(fund);
		}
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("teachList", funds);// step 3
		return "stu";
	}
	
=======
>>>>>>> origin/struts2
	public String teach() throws SQLException
	{
		List funds = new ArrayList<teach_prog>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from teaching_programme";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			teach_prog fund = new teach_prog();
			fund.setId(rs.getInt("id"));
			fund.setTitle(rs.getString("title"));
			fund.setContent(rs.getString("content"));
			fund.setYeaR(rs.getInt("year"));
			fund.setTime(rs.getDate("time"));
			funds.add(fund);
		}
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("teachList", funds);// step 3
		return SUCCESS;
	}
<<<<<<< HEAD
	
=======
>>>>>>> origin/struts2
	public String addteach() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO teaching_programme(title,content,year,time) VALUES (?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, year);
		Date now = new Date(System.currentTimeMillis()); 
		pstmt.setDate(4, now);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
		return SUCCESS;
	}
	public String deleteteach() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from  teaching_programme where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deleteid);
		pstmt.executeUpdate();
		return SUCCESS;
	}
}
