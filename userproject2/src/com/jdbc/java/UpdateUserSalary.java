package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import com.entity.pojo.User;
import com.service.java.RaiseSalary;

public class UpdateUserSalary {

	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;

//	static String usr = "root";
//	static String pwd = "prabhakar";
//	static String url = "jdbc:mysql://localhost:3306/Core";
	public static void updateUserSalary(int uid, Long salary) throws ClassNotFoundException, SQLException {

//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(url,usr,pwd);
		pst = con.prepareStatement("update user set userSalary = ? where userId = ?");
		pst.setLong(1, salary);
		pst.setLong(2, uid);
		int r = pst.executeUpdate();
		if (r == 1) {
			System.out.println("updation succesful");
		} else {
			System.out.println("updation unsuccesful");

		}
	}

}
