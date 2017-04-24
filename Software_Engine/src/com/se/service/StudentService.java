package com.se.service;
import com.se.util.PageBean;

public interface StudentService {
	PageBean getStudents(int pageNo);  //根据页码，返回PageBean对象
}
