package com.se.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.se.domain.report;
import com.se.util.JDBCUtil;

public class ReportDaoJDBCImpl {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	public report getreport(int stu_id,int expid) throws SQLException
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
		JDBCUtil.close(null, pstmt, conn);
		return r;
	}
	
	public void submit(int stu_id,String title,String content,int expid) throws SQLException
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
		JDBCUtil.close(null, pstmt, conn);
	}
}
