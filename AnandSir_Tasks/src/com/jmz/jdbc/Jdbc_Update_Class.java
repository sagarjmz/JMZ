package com.jmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Jdbc_Update_Class {
	static Connection con;
	static Statement st;
	static String url = "jdbc:mysql://localhost:3306/emp";
	static String usr = "root";
	static String pwd = "Year@2021";
	
	public static void update(String uid, int usalary) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,usr,pwd);
		PreparedStatement pst=con.prepareStatement("update emp_table set emp_salary =? where emp_id=?");
		pst.setInt(1, usalary);
		pst.setString(2, uid);
		int r=pst.executeUpdate();
		if(r==1) {
			System.out.println("updated sucessfully");
		}else {
			System.out.println("error");
		}
	}

}
