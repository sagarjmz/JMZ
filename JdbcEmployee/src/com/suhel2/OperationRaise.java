package com.suhel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OperationRaise {
	 
	public static void operationRaise() {
		int eId = Raise.empId;
		int eSal = Raise.empSalary;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
			PreparedStatement pst = con.prepareStatement("update empdata set eSal = ? where eId = ?");
			pst.setInt(1, eSal);			
			pst.setInt(2, eId);
			int r = pst.executeUpdate();
			
			if (r == 1) {
				System.out.println(" :-updation succesful-: ");
			} else {
				System.out.println(" :-unsuccesful-: ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
