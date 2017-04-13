package com.se.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
* Description: TODO
* @author 
* @date 2017年2月25日 下午2:37:05
 */
public class JDBCUtil {
	private static final String CONNURL = "jdbc:mysql://localhost:3306/study?characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	/*使用静态代码块完成驱动的加载*/
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*提供连接的方法*/
	public static Connection getConnection() {
		Connection con = null;
		try {
			//连接指定的MMySQL数据库，三个参数分别是：数据库地址、账号、密码
			con = DriverManager.getConnection(CONNURL,USERNAME , PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	/*关闭连接的方法*/
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
