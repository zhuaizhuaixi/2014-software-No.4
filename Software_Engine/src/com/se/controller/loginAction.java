package com.se.controller;

import java.util.Map;
import com.se.dao.*;
import javax.servlet.http.HttpSession;

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
	
	public String login()
	{
		ActionContext ctx = ActionContext.getContext();
		
		//2. 创建dao或者service对象
		if(radio.compareTo("on")==0)
			radio="student";
		UserDao userDao=new UserDaoJDBCImpl();
		boolean flag=userDao.validate(username, password,radio);
		System.out.println(username+password+radio);
		
		
		if(flag)
		{
			ctx.getSession().put("username", username);
			return SUCCESS;
		}
		else
			return "input";
	}
	public loginAction() {
		
	}

}
