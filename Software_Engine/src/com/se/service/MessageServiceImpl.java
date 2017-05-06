package com.se.service;


import java.sql.SQLException;

import com.se.dao.MessageDaoJDBCImpl;
import com.se.util.PageBean;

public class MessageServiceImpl  {
	private MessageDaoJDBCImpl messageDao=new MessageDaoJDBCImpl();
	
	public PageBean getMessages(int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=messageDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=messageDao.findRowCount();
		pageBean.countMaxPage();
		return pageBean;
	}

	public void insertmessage(String msg,int msgerid) throws SQLException
	{
		System.out.println(msg+msgerid);
		messageDao.submit(msg, msgerid);
	}
}
