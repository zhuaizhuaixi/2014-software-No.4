package com.se.domain;

import java.util.Date;

public class Student {
	private String id;
	private String  name;
	private String  password;
	private String  sex;
	private Date    last_login;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public Student(String id, String name, String password ,String sex ,Date last_login) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.sex=sex;
		this.last_login=last_login;
	}
	public Student() {
		super();
	}	
}
