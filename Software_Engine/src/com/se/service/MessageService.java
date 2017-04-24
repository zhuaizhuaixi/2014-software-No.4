package com.se.service;
import com.se.util.PageBean;

public interface MessageService {
	PageBean getMessages(int pageNo);  //根据页码，返回PageBean对象
}
