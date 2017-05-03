package com.se.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.*;
import com.se.util.JDBCUtil;

public class expAction extends ActionSupport {
	private int expid;
	public int getExpid() {
		return expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}
	private String experiment;
	private String requires;
	private int reportid;
	private int mark;
	private int stu_id;
	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public int getReportid() {
		return reportid;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	private int detail_id;
	public String getExperiment() {
		return experiment;
	}

	public void setExperiment(String experiment) {
		this.experiment = experiment;
	}

	public String getRequires() {
		return requires;
	}

	public void setRequires(String requires) {
		this.requires = requires;
	}

	public String show() throws SQLException
	{
		List funds = new ArrayList<experiment>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from experiment";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			experiment fund = new experiment();
			fund.setId(rs.getInt("id"));
			fund.setExperiment(rs.getString("experiment"));
			fund.setRequires(rs.getString("requires"));
			funds.add(fund);
		}
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("expList", funds);// step 3
		return SUCCESS;
	}
	
	public String show_stu() throws SQLException
	{
		List funds = new ArrayList<experiment>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from experiment";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			experiment fund = new experiment();
			fund.setId(rs.getInt("id"));
			fund.setExperiment(rs.getString("experiment"));
			fund.setRequires(rs.getString("requires"));
			funds.add(fund);
		}
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("expList", funds);// step 3
		return "stu_show";
	}
	
	public String detail() throws SQLException
	{
		String expname="";
		String expreq="";
		List funds = new ArrayList<exp_report>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select report.id,student.name,report.title,report.score from student,report,experiment where experiment.id=report.expid and report.student=student.id and experiment.id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
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
		sql="select experiment,requires from experiment where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, detail_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			expname=rs.getString("experiment");
			expreq=rs.getString("requires");
		}
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("id", detail_id);
		request.put("detailList", funds);// step 3
		request.put("experiment", expname);
		request.put("requires",expreq);	
		return "detail";
	}
	
	public String detail_stu() throws SQLException
	{
		String expname="";
		String expreq="";
		int flag=0;
		Connection conn = JDBCUtil.getConnection();
		String sql ;
		PreparedStatement pstmt ;
		ResultSet rs ;
		sql="select experiment,requires from experiment where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, detail_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			expname=rs.getString("experiment");
			expreq=rs.getString("requires");
		}
		
		sql="select * from report where student=? and expid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stu_id);
		pstmt.setInt(2, detail_id);
		rs = pstmt.executeQuery();
		if(rs.next())
			flag=1;
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("id", detail_id);
		request.put("experiment", expname);
		request.put("requires",expreq);	
		request.put("flag", flag);
		return "detail_stu";
	}
	
	
	public String add() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into experiment(experiment,requires) values (?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, experiment);
		pstmt.setString(2, requires);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		return "show";
	}
	public String report() throws SQLException
	{
		List funds = new ArrayList<report>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from report where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, reportid);
		ResultSet rs = pstmt.executeQuery();
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
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("reportList",funds);
		return "report";
	}
	
	public String mark() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "update report set score = ? where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mark);
		pstmt.setInt(2, reportid);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		return "show";
	}
	public String change() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "select experiment,requires from experiment where id=?";
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
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("exp",exp);
		return "changeexp";
	}
	public String update() throws SQLException
	{
		Connection conn = JDBCUtil.getConnection();
		String sql = "update experiment set experiment = ? , requires=?  where id=?;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, experiment);
		pstmt.setString(2, requires);
		pstmt.setInt(3, expid);
		System.out.print(pstmt.toString());
		pstmt.executeUpdate();
		return "show";
	}
}
