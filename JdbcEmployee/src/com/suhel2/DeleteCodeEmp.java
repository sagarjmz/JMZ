package com.suhel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteCodeEmp {
	
	public static void deleteCodeEmp() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id : ");
		int eId = sc.nextInt();
		
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
			PreparedStatement pst = con.prepareStatement("delete from empdata where eId = ?");
			pst.setInt(1, eId);			
			
			int r = pst.executeUpdate();
			
			if (r == 1) {
				System.out.println(" :-Deleted succesfully-: ");
			} else {
				System.out.println(" :-unsuccesful-: ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
