package com.wf.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/db_demo1";
	public static final String DBUSER="root";
	public static final String DBPWD="root";
		
	

	public static void main(String[] args) {
		Connection conn =null;
		Statement st = null;
		
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPWD);
			
			st=conn.createStatement();
			
			String sql = "insert into school(name,addr)values";
			
			st.executeUpdate(sql+"('ss1','ss1');");
			st.executeUpdate(sql+"('ss2','ss2');");
			st.executeUpdate(sql+"('ss3','ss3');");
			st.executeUpdate(sql+"('ss4','ss4');");
			System.out.println("修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}