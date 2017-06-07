package com.wf.db.jdbc.prepared;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;

//增加数据
public class DatebaseConnection {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/db_demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		// 注册
		Class.forName(DBDRIVER);
		// 链接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// 创建sql语句
		String sql = "insert into school (name,addr)values(?,?);";
		// preparedstatement 执行sql语句
		PreparedStatement pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, "sukid");
		pStatement.setString(2, "江知道");
		int i = pStatement.executeUpdate();

		System.out.println("1执行结束" + "i= " + i);

		// demo2
		String sql2 = "select *  from school ;";
		PreparedStatement pStatement2 = conn.prepareStatement(sql2);
		// demo2 result set
		ResultSet rSet = pStatement.executeQuery(sql2);
		System.out.println("id" + "\t\t" + "name" + "\t\t" + "addr" + "\t\t");
		while (rSet.next()) {
			String name = rSet.getString("name");
			int id = rSet.getInt("id");
			String addr = rSet.getString("addr");
			System.out.print(id + "\t\t");
			System.out.print(name + "\t\t");
			System.out.print(addr + "\t\t");
			System.out.println();

		}
		System.out.println("2执行结束");

		// 释放
		rSet.close();
		pStatement2.close();
		pStatement.close();
		conn.close();

	}

}
