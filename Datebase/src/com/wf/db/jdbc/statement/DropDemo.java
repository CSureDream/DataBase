package com.wf.db.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropDemo {
	
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/db_demo1";
	public static final String DBUSER="root";
	public static final String DBPWD="root";
	


	public static void main(String[] args) throws Exception {
		Connection conn =null;
		Statement stmt =null;
			
		Class.forName(DBDRIVER);
		conn =DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		String sql ="delete from school where id=2;";
		stmt=conn.createStatement();
		stmt.executeLargeUpdate(sql);
		stmt.close();
		conn.close();
	}

}
