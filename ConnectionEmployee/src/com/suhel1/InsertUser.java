package com.suhel1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class InsertUser {
	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;


	public static void insertUser(User user) throws SQLException, ClassNotFoundException {

		pst = con.prepareStatement("insert into employee values(null,?,?,?,?)");
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

