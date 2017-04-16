package com.se.dao;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.se.domain.Student;
import com.se.util.JDBCUtil;

/**
 * Description: TODO
 * 
 * @author
 * @date 2017年2月25日 下午3:05:25
 */
public class StudentDaoJDBCImpl implements StudentDao {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public List findAll() {

		List funds = new ArrayList<Student>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student fund = new Student();
				fund.setId(rs.getString("id"));
				fund.setName(rs.getString("name"));
				fund.setPassword(rs.getString("password"));
				fund.setSex(rs.getString("sex"));
				fund.setLast_login(rs.getDate("last_login"));
				funds.add(fund);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return funds;
	}

	@Override
	public void insert(Student fund) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into student(id, name, password, sex, last_login) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fund.getId());
			pstmt.setString(2, fund.getName());
			pstmt.setString(3, fund.getPassword());
			pstmt.setString(4, fund.getSex());
			// 需要把java.util.Date 转为 java.sql.Date
			pstmt.setDate(5, new java.sql.Date(fund.getLast_login().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	@Override
	public void delete(int fundNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fundNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	@Override
	public void update(Student fund) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update student set password=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fund.getPassword());
			pstmt.setString(2, fund.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
	}

	@Override
	public Student findById(int fundNo) {
		// TODO Auto-generated method stub
		Student fund = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fundNo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				fund = new Student();
				fund.setId(rs.getString("id"));
				fund.setName(rs.getString("name"));
				fund.setPassword(rs.getString("password"));
				fund.setSex(rs.getString("sex"));
				fund.setLast_login(rs.getDate("last_login"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return fund;
	}

	@Override
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds = new ArrayList<Student>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from student limit ?, ?"; //limit
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student fund = new Student();
				fund.setId(rs.getString("id"));
				fund.setName(rs.getString("name"));
				fund.setPassword(rs.getString("password"));
				fund.setSex(rs.getString("sex"));
				fund.setLast_login(rs.getDate("last_login"));
				
				funds.add(fund);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return funds;
	}

	@Override
	public int findRowCount() {
		int count=0;
		// TODO Auto-generated method stub
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from student"; 
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return count;
	}

}
