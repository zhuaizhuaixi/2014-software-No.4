package com.se.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.se.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.*;
import com.se.util.JDBCUtil;

public class expAction extends ActionSupport {
	private int expid;
	private ExperimentDaoJDBCImpl expdao= new ExperimentDaoJDBCImpl();
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
		funds=expdao.show();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("expList", funds);// step 3
		return SUCCESS;
	}
	
	public String show_stu() throws SQLException
	{
		List funds = new ArrayList<experiment>();
		funds=expdao.show();
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("expList", funds);// step 3
		return "stu_show";
	}
	
	public String detail() throws SQLException
	{
		List funds = new ArrayList<exp_report>();
		funds=expdao.getreport(detail_id);
		
		
		String [] exp = new String [2];
		exp=expdao.getrequire(detail_id);
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("id", detail_id);
		request.put("detailList", funds);// step 3
		request.put("experiment", exp[0]);
		request.put("requires",exp[1]);	
		return "detail";
	}
	
	public String detail_stu() throws SQLException
	{
		String [] exp = new String [2];
		exp=expdao.getrequire(detail_id);
		
		int flag= expdao.issubmit(stu_id, detail_id);
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("id", detail_id);
		request.put("experiment", exp[0]);
		request.put("requires",exp[1]);	
		request.put("flag", flag);
		return "detail_stu";
	}
	
	
	public String add() throws SQLException
	{
		expdao.addexp(experiment, requires);
		return "show";
	}
	public String report() throws SQLException
	{
		List funds = new ArrayList<report>();
		funds=expdao.report(reportid);
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("reportList",funds);
		return "report";
	}
	
	public String mark() throws SQLException
	{
		expdao.mark(mark, reportid);
		return "show";
	}
	
	public String change() throws SQLException
	{
		
		experiment exp=expdao.getchange(expid);
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("exp",exp);
		return "changeexp";
	}
	public String update() throws SQLException
	{
		expdao.update(experiment, requires, expid);
		return "show";
	}
}
