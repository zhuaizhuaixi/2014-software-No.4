package com.se.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se.domain.exp_report;
import com.se.domain.experiment;
import com.se.domain.report;
import com.se.util.JDBCUtil;

public class ExperimentDaoJDBCImpl 
{
	Connection conn=null;
	String sql =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public List show() throws SQLException
	{
		List funds = new ArrayList<experiment>();
		conn = JDBCUtil.getConnection();
		String sql = "select * from experiment";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			experiment fund = new experiment();
			fund.setId(rs.getInt("id"));
			fund.setExperiment(rs.getString("experiment"));
			fund.setRequires(rs.getString("requires"));
			funds.add(fund);
		}
		JDBCUtil.close(rs, pstmt, conn);
		return funds;
	}
	
	public List getreport(int detail_id) throws SQLException
	{
		List funds = new ArrayList<exp_report>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select report.id,student.name,report.title,report.score from student,report,experiment where experiment.id=report.expid and report.student=student.id and experiment.id=?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, detail_id);
		System.out.println(pstmt.toString());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			exp_report fund = new exp_report();
			fund.setId(rs.getInt("id"));
			fund.setName(rs.getString("name"));
			fund.setTitle(rs.getString("title"));
			fund.setScore(rs.getInt("score"));
			funds.add(fund);
		}
		JDBCUtil.close(rs, pstmt, conn);
		return funds;
	}
	
	public String[] getrequire(int detail_id) throws SQLException
	{
		String expname="";
		String expreq="";
		Connection conn = JDBCUtil.getConnection();
		sql="select experiment,requires from experiment where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, detail_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			expname=rs.getString("experiment");
			 expreq=rs.getString("requires");
		}
		String [] exp = new String [2];
		exp[0]=expname;
		exp[1]=expreq;
		JDBCUtil.close(rs, pstmt, conn);
		return exp;
		
	}
	
	public int issubmit(int stu_id,int detail_id) throws SQLException
	{
		int flag=0;
		conn=JDBCUtil.getConnection();
		sql="select * from report where student=? and expid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stu_id);
		pstmt.setInt(2, detail_id);
		rs = pstmt.executeQuery();
		if(rs.next())
			flag=1;
		JDBCUtil.close(rs, pstmt, conn);
		return flag;
	}
	
	public void addexp(String experiment,String requires) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		sql = "insert into experiment(experiment,requires) values (?,?);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, experiment);
		pstmt.setString(2, requires);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}
	
	public List report(int reportid) throws SQLException
	{
		List funds = new ArrayList<report>();
		conn = JDBCUtil.getConnection();
		sql = "select * from report where id=?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, reportid);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			report r=new report();
			r.setId(reportid);
			r.setTime(rs.getDate("time"));
			r.setTitle(rs.getString("title"));
			r.setContent(rs.getString("content"));
			r.setScore(rs.getInt("score"));
			funds.add(r);
		}
		JDBCUtil.close(rs, pstmt, conn);
		return funds;
	}
	
	public void mark(int mark,int reportid) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		sql = "update report set score = ? where id=?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mark);
		pstmt.setInt(2, reportid);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}
	
	public experiment getchange(int expid) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		 sql = "select experiment,requires from experiment where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, expid);
		ResultSet rs = pstmt.executeQuery();
		experiment exp=new experiment();
		while(rs.next())
		{	
			exp.setId(expid);
			exp.setExperiment(rs.getString("experiment"));
			exp.setRequires(rs.getString("requires"));
		}
		JDBCUtil.close(rs, pstmt, conn);
		return exp;
	}
	
	public void update(String experiment,String requires,int expid) throws SQLException
	{
		conn = JDBCUtil.getConnection();
		sql = "update experiment set experiment = ? , requires=?  where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, experiment);
		pstmt.setString(2, requires);
		pstmt.setInt(3, expid);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		JDBCUtil.close(rs, pstmt, conn);
	}
}
