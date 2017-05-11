package com.se.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.se.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.se.domain.practice;
import com.se.domain.result;
import com.se.util.JDBCUtil;

public class practiceAction extends ActionSupport {
	private PracticeDaoJDBCImpl pradao=new PracticeDaoJDBCImpl();
	private String subject;
	private int [] exid= new int[15];
	public int[] getExid() {
		return exid;
	}

	public void setExid(int[] exid) {
		this.exid = exid;
	}
	private String [] question = new String[15];
	private String [] no = new String[15];
	private String [] as = new String[15];
	public String[] getNo() {
		return no;
	}

	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
	}

	public void setNo(String[] no) {
		this.no = no;
	}

	public String[] getAs() {
		return as;
	}

	public void setAs(String[] as) {
		this.as = as;
	}

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
		funds=pradao.getpractice();
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("practList", funds);// step 3
		return SUCCESS;
	}
	
	public String addpractice() throws SQLException
	{
		pradao.addpractice(subject, A, B, C, D, answer);
		
		return SUCCESS;
	}
	
	public String deletepractice() throws SQLException
	{
		pradao.delete(deleteid);
		return SUCCESS;
	}
	
	public String showpractice_stu() throws SQLException
	{
		List funds = new ArrayList<practice>();
		funds=pradao.show_stu();
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("practList", funds);// step 3
		return "practice_stu";
	}
	
	public String practice_stu_result() throws SQLException
	{
		int sum=pradao.getright(exid, no);
		List results = new ArrayList<result>();
		results=pradao.result(exid, no, question, as);
		
		ActionContext ctx = ActionContext.getContext();
		Map request = (Map)ctx.get("request");
		request.put("mark", sum);
		request.put("result", results);
		return "stu_result";
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
