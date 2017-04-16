package com.se.controller;
import com.se.domain.*;
import com.se.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.se.dao.StudentDao;
import com.se.dao.StudentDaoJDBCImpl;
import com.opensymphony.xwork2.ActionSupport;

public class insert_studentAction extends ActionSupport {
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	private StudentDao studentDao=new StudentDaoJDBCImpl();
	public String insert()
	{
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		Date date=null;
		try {
			date = sdf.parse( " 1900-01-01 00:00:00 " );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setPassword(student.getId());
		student.setLast_login(date);
		studentDao.insert(student);
		return SUCCESS;
	}
	public insert_studentAction() {
		// TODO Auto-generated constructor stub
	}

}
