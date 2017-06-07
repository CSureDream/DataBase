package com.wf.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/db_demo1";
	public static final String DBUSER="root";
	public static final String DBPWD="root";
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Connection conn =null;
			Statement stmt =null;
			try {
		//注册
				Class.forName(DBDRIVER);
		//链接	
				conn =	DriverManager.getConnection(DBURL,DBUSER,DBPWD);
		//创建语句
				String sql ="update school set name='ss' where id=3; ";
		//执行语句
				stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				System.out.println("修改成功");
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}

