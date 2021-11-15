package com.main.corejava;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.java.UserConnection;
import com.service.java.CreateUser;
import com.service.java.DisplayUser;
import com.service.java.RaiseSalary;

//sub branch of project
public class MainClass {

	public static void main(String[] args) {
		int n = 0;
		String value;
		Scanner sc;
		// in create add age
		// add id and auto generate
		// display name age designation salary id
		// in raise salary : ask empid and name true
		// raiseSalary means update salary by somePercent
		try {
			UserConnection.openConnection(); // open db connection
		}
			catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("something wrong in opening connection");
			}
			
			while (n == 0) // infinite loop terminate when exit option is selected
			{
				sc = new Scanner(System.in);
				System.out.println("choose 1)create 2)display 3)raiseSalary 4)exit ");
				value = sc.nextLine();
				try {
					if (value.equals("1")) {
						CreateUser.createUser(); // call method for create user
					} else if (value.equals("2")) {

						DisplayUser.displayUser();// call method for display user details

					} else if (value.equals("3")) {
						RaiseSalary.raiseSalary(); // call method for raiseSalary user details
					} else if (value.equals("4")) {
						n = 1; // terminate code
					} else {
						System.out.println("enter proper input"); // except specified value
						System.out.println();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
	
		try {
			UserConnection.closeConnection(); // close db connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong in closig connection");
		}
		System.out.println("program terminated");

	}

}
