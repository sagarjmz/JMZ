package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","root");
		return con;
	}

}
