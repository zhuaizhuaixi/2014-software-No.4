package com.se.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.se.util.JDBCUtil;

public class UserDaoJDBCImpl implements UserDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	@Override
	public boolean validate(String userName, String password,String radio) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//1. 获取连接
		conn=JDBCUtil.getConnection();
		//2. 写Sql语句
		String sql="select * from "+radio+" where id=? and password=?";
		//3. 创建PreparedStatement对象
		try {
			pstmt=conn.prepareStatement(sql);
		//4. 给sql语句变量赋值
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
		//5. 发送执行sql语句
			System.out.print(pstmt.toString());
			rs=pstmt.executeQuery();
		//6.对ResultSet对象处理
			if (rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
		//7. 关闭资源
			JDBCUtil.close(rs, pstmt, conn);
		}

		return flag;
	}

}
