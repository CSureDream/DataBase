package com.wf.db.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			PreparedStatement pStatement=null;
			try {
		//注册
				Class.forName(DBDRIVER);
		//链接	
				conn =	DriverManager.getConnection(DBURL,DBUSER,DBPWD);
		//创建语句
				String sql ="update school set name='ss' where id=3; ";
		//执行语句
				pStatement=conn.prepareStatement(sql);
				int i=pStatement.executeUpdate(sql);
				System.out.println("修改成功"+"i="+i);
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				try {
					pStatement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}

