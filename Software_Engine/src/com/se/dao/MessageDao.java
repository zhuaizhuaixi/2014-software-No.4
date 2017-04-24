package com.se.dao;
import java.util.List;

public interface MessageDao {
	List findByPage(int pageNo, int pageSize); 
	int  findRowCount();    
}
