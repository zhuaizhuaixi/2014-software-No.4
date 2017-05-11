package com.se.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.se.util.JDBCUtil;

public class UserDaoJDBCImpl  {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public boolean validate(String userName, String password,String radio) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		conn=JDBCUtil.getConnection();
		
		String sql="select * from "+radio+" where id=? and password=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
		
			System.out.print(pstmt.toString());
			rs=pstmt.executeQuery();
		
			if (rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
		
			JDBCUtil.close(rs, pstmt, conn);
		}

		return flag;
	}
	
	public String[] getpeople(String username,String radio) throws SQLException
	{
		conn=JDBCUtil.getConnection();
		String [] inf = new String [2]; 
		String sql = "select * from "+radio+" where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			inf[0]=rs.getString("name");
			inf[1]=rs.getInt("id")+"";
		}
		JDBCUtil.close(rs, pstmt, conn);
		return inf;
	}
	
	public void logintime(String radio,int id) throws SQLException
	{
		conn=JDBCUtil.getConnection();
		String sql = "update "+radio+" set last_login=? where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		java.util.Date date=new java.util.Date();
		Timestamp tt=new Timestamp(date.getTime());
		pstmt.setTimestamp(1, tt);
		pstmt.setInt(2, id);
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}

}
