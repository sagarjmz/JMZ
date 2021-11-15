package com.jdbc.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserSalary {

	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;

	public static void updateUserSalary(int uid, Long salary) throws ClassNotFoundException, SQLException {
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
