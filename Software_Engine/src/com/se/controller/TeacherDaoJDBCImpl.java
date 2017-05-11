package com.se.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.se.domain.teach_prog;
import com.se.util.JDBCUtil;

public class TeacherDaoJDBCImpl {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public List show() throws SQLException
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
		JDBCUtil.close(rs, pstmt, conn);
		return funds;
	}
	
	public void add(String title,String content,int year) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO teaching_programme(title,content,year,time) VALUES (?,?,?,?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, year);
		Date now = new Date(System.currentTimeMillis()); 
		pstmt.setDate(4, now);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();	
		sql="UPDATE teaching_programme SET content = REPLACE(content, '\\r\\n', '<br/>')";
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}
	
	public void delete(int deleteid) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		String sql = "delete from  teaching_programme where id=?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deleteid);
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}

}
