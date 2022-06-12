package com.simplilearn.workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnectionUtil {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		// Load a Driver
		Class.forName(driverClassName);
		String strURL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";
		String strUser = "root";
		String strPassword = "Welcome1";
		Connection conn = DriverManager.getConnection(strURL, strUser, strPassword);
		return conn;
	}
}
