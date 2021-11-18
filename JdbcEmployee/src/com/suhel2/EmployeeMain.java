package com.suhel2;

import java.sql.SQLException;
import java.util.Scanner;



public class EmployeeMain {
	
	static void employeeMain() {
		try {
			EmployeeConnection.openConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println(" :-unable to establish connection-: ");
		}
		
		int n= 0;
		String res;
		Scanner sc;
		while (n == 0)
		{
			sc = new Scanner(System.in);
			System.out.println(" CHOOSE 1)CREATE 2)DISPLAY 3)RAISE SALARY 4)EXIT : ");
			res = sc.nextLine();
			try {
				if (res.equals("1")) {
					CreateEmployee.createEmployee();
				} else if (res.equals("2")) {

					DisplayEmployee.fetch();
					

				} else if (res.equals("3")) {
					Raise.raise();
				} else if (res.equals("4")) {
					EmployeeConnection.closeConnection();
					n = 1;
				} else {
					System.out.println(" :-enter proper input-: ");
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			EmployeeConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("something wrong in closig connection");
		}
		System.out.println(" DISCONNECTED ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeMain.employeeMain();

	}

}
