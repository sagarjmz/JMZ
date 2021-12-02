package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserConnection {
	public static Connection con;
	public static Statement st;
	static Connection con1 =null;
	static Statement st1 = null;
	static PreparedStatement pst;
	static String usr = "root";
	static String pwd = "prabhakar";
	static String url = "jdbc:mysql://localhost:3306/Core";

	public static void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
			st= con.createStatement();
			System.out.println("DB connection established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void closeConnection() throws SQLException {
		con.close();
		System.out.println("DB connection closed");
	}
	
	public static void openLoginConnection()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","prabhakar");
			System.out.println("login connection open");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
