package com.se.service;

import com.se.dao.MessageDao;
import com.se.dao.MessageDaoJDBCImpl;
import com.se.util.PageBean;

public class MessageServiceImpl implements MessageService {
	private MessageDao messageDao=new MessageDaoJDBCImpl();
	@Override
	public PageBean getMessages(int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.data=messageDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=messageDao.findRowCount();
		pageBean.countMaxPage();
		return pageBean;
	}

}
