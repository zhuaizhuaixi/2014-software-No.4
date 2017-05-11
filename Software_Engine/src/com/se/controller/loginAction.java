package com.se.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import com.se.dao.*;
import javax.servlet.http.HttpSession;
import com.se.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {

	private String username;
	private String password;
	private String radio;
	

	
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() throws SQLException
	{
		ActionContext ctx = ActionContext.getContext();
		
		//2. 鍒涘缓dao鎴栬�卻ervice瀵硅薄
		if(radio.compareTo("on")==0)
			radio="student";
		UserDaoJDBCImpl userDao=new UserDaoJDBCImpl();
		boolean flag=userDao.validate(username, password,radio);
		System.out.println(username+password+radio);
		
		String[] inf = new String [2];
		
		if(flag)
		{
			inf=userDao.getpeople(username, radio);
			userDao.logintime(radio, Integer.parseInt(username));
			ctx.getSession().put("username", inf[0]);
			ctx.getSession().put("value",Integer.parseInt(inf[1]));
			if(radio.compareTo("student")==0)
				return "student";
			else
				return "teacher";
		}
		else
			return "input";
	}
	public String loginout() {
		ActionContext context = ActionContext.getContext();
		context.getSession().remove("username");
		context.getSession().remove("value");

		return "login";
	}

}
