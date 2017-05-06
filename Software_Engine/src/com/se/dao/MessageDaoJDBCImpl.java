package com.se.dao;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.se.domain.message;
import com.se.util.JDBCUtil;


public class MessageDaoJDBCImpl  {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds = new ArrayList<message>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select student.name,message_board.id,message_board.content,message_board.time from student,message_board where author=student.id  UNION select teacher.name,message_board.id,message_board.content,message_board.time from teacher,message_board where author=teacher.id order by time desc limit ?,?"; //limit
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			System.out.println(pstmt.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				message fund = new message();
				fund.setId(rs.getInt("id"));
				fund.setAuthor_name(rs.getString("name"));
				fund.setContent(rs.getString("content"));
				fund.setTime(rs.getTimestamp("time"));			
				funds.add(fund);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return funds;
	}

	
	public int findRowCount() {
		int count=0;
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from message_board"; 
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return count;
	}

	public void submit(String msg,int msgerid) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO message_board(content,author,time) VALUES (?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  msg);
		pstmt.setInt(2, msgerid);
		java.util.Date date=new java.util.Date();
		Timestamp tt=new Timestamp(date.getTime());
		pstmt.setTimestamp(3, tt);
		System.out.println(pstmt.toString());
		pstmt.executeUpdate();
	}

}
