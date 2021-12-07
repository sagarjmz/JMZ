package com.jmz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con;
	public static Connection getSqlConnection() throws ClassNotFoundException,SQLException  {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","root");
		
		return con;
		
	}
}
