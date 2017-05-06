package com.se.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.se.domain.Student;
import com.se.dao.StudentDaoJDBCImpl;
import com.se.util.PageBean;

public class StudentServiceImpl  {
	private StudentDaoJDBCImpl studentDao=new StudentDaoJDBCImpl();
	
	public PageBean getStudents(int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=studentDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=studentDao.findRowCount();
		pageBean.countMaxPage();
		return pageBean;
	}

	public void insertstudent(Student student)
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
	}
}
