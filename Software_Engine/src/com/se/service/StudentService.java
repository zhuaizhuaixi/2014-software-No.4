package com.se.service;
import com.se.util.PageBean;

public interface StudentService {
	PageBean getFunds(int pageNo);  //根据页码，返回PageBean对象
}
