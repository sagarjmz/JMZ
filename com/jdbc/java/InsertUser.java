package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.java.User;

public class InsertUser {
	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;
//	static String usr = "root";
//	static String pwd = "prabhakar";
//	static String url = "jdbc:mysql://localhost:3306/Core";

	public static void insertUser(User user) throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(url, usr, pwd);

		pst = con.prepareStatement("insert into user values(null,?,?,?,?)");
		pst.setString(1, user.getName());
		pst.setString(2, user.getDesignation());
		pst.setInt(3, user.getAge());
		pst.setLong(4, user.getSalary());
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("insertion succesfull");
		} else {
			System.out.println("insertion un succesful");
		}
	}

}
