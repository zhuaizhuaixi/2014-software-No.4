package com.se.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se.dao.*;
import com.se.domain.teach_prog;

public class TeacherServiceImpl {

	private TeacherDaoJDBCImpl teachdao = new TeacherDaoJDBCImpl();
	
	public List teach() throws SQLException
	{
		List funds = new ArrayList<teach_prog>();
		funds = teachdao.show();
		return funds;
	}
	
	public void add(String title,String content,int year) throws SQLException
	{
		teachdao.add(title, content, year);
	}

}
