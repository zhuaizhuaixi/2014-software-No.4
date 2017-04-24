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
import com.se.domain.practice;
import com.se.util.JDBCUtil;

public class practiceAction extends ActionSupport {
	private String subject;
	private String A;
	private String B;
	private String C;
	private String D;
	private String answer;
	private int deleteid;
	public int getDeleteid() {
		return deleteid;
	}

	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}

	public String practice() throws SQLException
	{
		List funds = new ArrayList<practice>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from exercises";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			practice fund = new practice();
			fund.setId(rs.getInt("id"));
			fund.setSubject(rs.getString("subject"));
			fund.setA(rs.getString("A"));
			fund.setB(rs.getString("B"));
			fund.setC(rs.getString("C"));
			fund.setD(rs.getString("D"));
			fund.setAnswer(rs.getString("answer"));
			funds.add(fund);
		}
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("practList", funds);// step 3
		return SUCCESS;
	}
	
	public String addpractice() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO exercises(subject,A,B,C,D,answer) VALUES (?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject);
		pstmt.setString(2, A);
		pstmt.setString(3, B);
		pstmt.setString(4, C);
		pstmt.setString(5, D);
		pstmt.setString(6, answer);
		pstmt.executeUpdate();
		
		return SUCCESS;
	}
	
	public String deletepractice() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from  exercises where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deleteid);
		pstmt.executeUpdate();
		return SUCCESS;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
