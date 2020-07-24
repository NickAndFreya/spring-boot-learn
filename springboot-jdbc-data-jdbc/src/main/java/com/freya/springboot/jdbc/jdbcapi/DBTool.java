package com.freya.springboot.jdbc.jdbcapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	static {
		//在类加载时只读取一次配置文件
		Properties p = new Properties();
		try {
			p.load(DBTool.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			//只需要加载一次驱动
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载配置文件失败", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载驱动类失败", e);
		}
	}
	
	/**
	 * 此处直接抛出SQLException,是为了强制
	 * 调用者去处理异常,从而避免其忘记写finally,
	 * 以及在finally当中关闭连接.
	 */
	public static Connection getConnection() 
		throws SQLException {
		return DriverManager
			.getConnection(url, user, pwd);
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
					"关闭连接失败", e);
			}
		}
	}

}







