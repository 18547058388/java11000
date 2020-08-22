package com.neusoft.elm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");//指定方言，加载驱动
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 建立连接
		 * @return
		 * @throws SQLException
		 */
		public static Connection getConnection() throws SQLException{
			String url = "jdbc:mysql://localhost:3306/element?characterEncoding=UTF-8&useUnicode=true";
			String user = "root";
			String password = "root";
			// 3）建立连接
			Connection  conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
		/**
		 * 关闭连接
		 * @param rs
		 * @param ps
		 * @param conn
		 * @throws SQLException
		 */
		public static  void closeConnection(ResultSet rs,Statement ps,Connection conn) throws SQLException{
			if(rs!=null){
			  rs.close();
			}
			if(ps!=null){
			 ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}


