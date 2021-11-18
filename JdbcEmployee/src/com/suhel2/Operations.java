package com.suhel2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Operations {
	public static void operations(Employee emp) throws SQLException, ClassNotFoundException {
		try {
 
			Class.forName("com.mysql.cj.jdbc.Driver");

 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");

			
			PreparedStatement pst = con.prepareStatement("insert into empdata values(null"
					+ ",?,?,?,?)");
			

 
			pst.setString(1, Employee.geteName());
			pst.setInt(2, Employee.geteAge());
			pst.setString(3, Employee.geteDesignation());
			pst.setInt(4, Employee.geteSal());
			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println(" :-success-:");
			} else {
				System.out.println(" :-failiure-: ");
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

		
	
}
