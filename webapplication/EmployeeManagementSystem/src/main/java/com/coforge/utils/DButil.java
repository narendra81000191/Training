package com.coforge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	// it is used for the jdbc connection
	 private static final String urlString = "jdbc:mysql://localhost:3306/cfgdb";
	private  static final String unameString = "user1";
     private static final String passwordString = "user@123";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        
        Connection connection = DriverManager.getConnection(urlString,unameString,passwordString);
        System.out.println("Connection Established");
		return connection;
	}

}

//
// 
//package com.coforge.util;
// 
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
// 
//public class DBUtil {
//	private static final String uname="root";
//	private static final String password = "Cfg@1234";
//	private static final String url="jdbc:mysql://localhost:3306/cfgdb";
//	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection(url,uname,password);
//		return con;
//	}
//}
// 