package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserConnection {
	static Connection con;
	static PreparedStatement pst;
	static String usr = "root";
	static String pwd = "scott";
	static String url = "jdbc:mysql://localhost:3306/jmzdata";

	public static void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		System.out.println("Database Connection Successfull !");
	}

	public static void closeConnection() throws SQLException {
		con.close();
		System.out.println("DB connection closed");
	}

}