package com.suhel1;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class FetchUserData {
	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;

	static public List<User> list = new ArrayList<User>();

	public static List<User> fetchUserData() throws SQLException, ClassNotFoundException {

		pst = con.prepareStatement("select * from employee");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			list.add(new User(rs.getString("userName"), rs.getString("userDesignation"), rs.getLong("userSalary"),
					rs.getInt("userId"), rs.getInt("userAge")));
		}

		return list;
	}

}

