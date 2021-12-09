package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static String url = "jdbc:mysql://localhost:3306/employee3";
	static String user = "root";
	static String password = "Ailesh@22";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		try {
			// Open a connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
