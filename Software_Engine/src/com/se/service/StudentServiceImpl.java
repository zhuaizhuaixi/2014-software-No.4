package com.se.service;

import com.se.dao.StudentDao;
import com.se.dao.StudentDaoJDBCImpl;
import com.se.util.PageBean;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao=new StudentDaoJDBCImpl();
	@Override
	public PageBean getStudents(int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=studentDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=studentDao.findRowCount();
		pageBean.countMaxPage();
		return pageBean;
	}

}
