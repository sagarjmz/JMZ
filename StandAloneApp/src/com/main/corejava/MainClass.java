package com.main.corejava;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.java.UserConnection;
import com.service.java.CreateUser;
import com.service.java.DisplayUser;
import com.service.java.RaiseSalary;

public class MainClass {

	public static void main(String[] args) {
		int n = 0;
		try {
			UserConnection.openConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();

			System.out.println("something wrong in openig connection");
		}
		String value;
		Scanner sc;
		while (n == 0) {
			sc = new Scanner(System.in);
			System.out.println("choose 1)create 2)display 3)raiseSalary 4)exit ");
			value = sc.nextLine();
			try {
				if (value.equals("1")) {
					CreateUser.createUser();
				} else if (value.equals("2")) {

					DisplayUser.displayUser();

				} else if (value.equals("3")) {
					RaiseSalary.raiseSalary();
				} else if (value.equals("4")) {
					n = 1; // terminate code
				} else {
					System.out.println("enter proper input");
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			UserConnection.closeConnection();
		} catch (SQLException e) {
			System.out.println("something wrong in closig connection");
		}
		System.out.println("program terminated");

	}

}
