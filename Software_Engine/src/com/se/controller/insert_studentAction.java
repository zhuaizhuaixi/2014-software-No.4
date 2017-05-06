package com.se.controller;
import com.se.domain.*;
import com.se.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.se.service.StudentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class insert_studentAction extends ActionSupport {
	private Student student;
	private StudentServiceImpl studentser=new StudentServiceImpl();
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String insert()
	{
		studentser.insertstudent(student);
		return SUCCESS;
	}
	

}
