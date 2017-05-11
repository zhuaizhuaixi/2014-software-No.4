package com.se.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se.domain.practice;
import com.se.domain.result;
import com.se.util.JDBCUtil;

public class PracticeDaoJDBCImpl {
	public List getpractice() throws SQLException
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
		JDBCUtil.close(null, pstmt, conn);
		return funds;
	}
	
	public void addpractice(String subject,String A,String B,String C,String D,String answer) throws SQLException
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
		JDBCUtil.close(null, pstmt, conn);
	}
	
	public void delete(int deleteid) throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from  exercises where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deleteid);
		pstmt.executeUpdate();
		JDBCUtil.close(null, pstmt, conn);
	}
	
	public List show_stu() throws SQLException
	{
		List funds = new ArrayList<practice>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from exercises order by rand() limit 0,10;";
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
		JDBCUtil.close(null, pstmt, conn);
		return funds;
	}
	
	public List result(int[] exid,String[] no,String [] question,String [] as) throws SQLException
	{
		List results = new ArrayList<result>();
		Connection conn = JDBCUtil.getConnection();
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		int i;
		for(i=1;i<=10;i++)
		{
			result res=new result();
			sql = "select * from exercises where id=? and answer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exid[i]);
			pstmt.setString(2, no[i]);
			rs= pstmt.executeQuery();
			if(rs.next())
				;
			else
			{
				sql = "select * from exercises where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, exid[i]);
				rs= pstmt.executeQuery();
				rs.next();
				res.setExid(exid[i]);
				res.setQuestion(question[i]);
				res.setChoose_id(no[i]);
				res.setChoose_text(rs.getString(no[i]));
				res.setRight_id(as[i]);
				res.setRight_text(rs.getString(as[i]));
				results.add(res);
			}
		}
		return results;
	}
	
	public int getright(int[] exid,String[] no) throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		int i,sum=0;
		for(i=1;i<=10;i++)
		{
			result res=new result();
			sql = "select * from exercises where id=? and answer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exid[i]);
			pstmt.setString(2, no[i]);
			rs= pstmt.executeQuery();
			if(rs.next())
				sum++;
		}
		return sum;
	}
}
