package com.dxc.cms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Canteen_Management";
		String user="root";
		String password="root";
		Class.forName(driver);
		connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
}
