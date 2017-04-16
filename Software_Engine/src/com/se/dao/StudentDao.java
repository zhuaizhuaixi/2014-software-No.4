package com.se.dao;
import java.sql.SQLException;
import java.util.List;
import com.se.domain.Student;
/**
* Description: TODO
* @author 
* @date 2017年2月25日 下午2:57:56
 */
public interface StudentDao {
	List findAll();    //获取所有的基金记录,返回Fund对象列表
	void insert(Student fund);    //插入一条基金记录
	void delete(int fundNo);    //按主键删除一条基金记录
	void update(Student fund);    //更新一条基金记录
	Student findById(int fundNo);  //按主键查找基金记录，返回Fund对象
	List findByPage(int pageNo, int pageSize); //获取一页的基金记录,返回Fund对象列表
	int  findRowCount();    //查找记录总数
}
