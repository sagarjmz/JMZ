package com.suhel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CreateEmployee {

	

	public static List li = new ArrayList();
	static int eId;
	static String eName;
	static int eAge;
	static String eDesignation;

	static int Sal[] = { 20000, 30000, 15000 };
	static int eSalary;
	static Scanner sc = new Scanner(System.in);

	public static void createEmployee() throws ClassNotFoundException, SQLException {
		int m = 0;
		while (m == 0) {
			int a = 0;
			while (a == 0) {
				int chkName = 0;
				System.out.println(" ENTER NAME : ");
				eName = sc.nextLine();
				String nameArr[] = eName.split(" ");

				if (nameArr.length > 3) {
					System.out.println(" :-only 3 words allowed-: ");
					a = 0;
				} else {
					for (String s : nameArr) {
						if (s.matches("[A-Za-z]+")) {
							chkName++;
						}
					}
					if (chkName == nameArr.length) {
						a = 1;
					} else {
						System.out.println(" -:only use alphabhets:- ");
						a = 0;
					}
				}

			}

			int c = 0;
			while (c == 0) {
				System.out.println(" ENTER AGE : ");
				String eAge1 = sc.nextLine();
				int ages = 0;
				if (eAge1.matches("[0-9][0-9]$")) {
					ages = Integer.valueOf(eAge1);
					if (ages >= 18 && ages <= 60) {
						c++;
						eAge = Integer.valueOf(eAge1);
					} else {
						System.out.println(" :-enter proper age-: ");
					}
				} else {
					System.out.println(" :-enter proper age-: ");
				}
			}
			int d = 0;
			while (d == 0) {
				System.out.println(" ENTER DESIGNATION 1)PROGRAMMER 2)MANAGER 3)TESTER : ");
				String s = sc.nextLine();
				String chk = s.replace(" ", "");

				if (chk.equalsIgnoreCase("programmer")) {
					eSalary = Sal[0];
					eDesignation = "programmer";

					int y = 0;
					while (y == 0) {
						System.out.println("enter y or n : ");
						String response = sc.nextLine();
						if (response.equalsIgnoreCase("n")) {
							m++;
							d = 1;
							y = 1;
						} else if (response.equalsIgnoreCase("y")) {
							m = 0;
							d = 1;
							y = 1;
						} else {
							System.out.println("enter y/n : ");

							y = 0;

						}
					}
				} else if (chk.equalsIgnoreCase("manager")) {
					eSalary = Sal[1];
					eDesignation = "manager";

					int y = 0;
					while (y == 0) {
						System.out.println("enter y or n : ");
						String response = sc.nextLine();
						if (response.equalsIgnoreCase("n")) {
							m++;
							d = 1;
							y = 1;
						} else if (response.equalsIgnoreCase("y")) {
							m = 0;
							d = 1;
							y = 1;
						} else {
							System.out.println("enter y/n : ");

							y = 0;

						}
					}
				} else if (chk.equalsIgnoreCase("tester")) {
					eSalary = Sal[2];
					eDesignation = "tester";

					int y = 0;
					while (y == 0) {
						System.out.println("enter y or n : ");
						String response = sc.nextLine();
						if (response.equalsIgnoreCase("n")) {
							m++;
							d = 1;
							y = 1;
						} else if (response.equalsIgnoreCase("y")) {
							m = 0;
							d = 1;
							y = 1;
						} else {
							System.out.println("enter y/n : ");

							y = 0;

						}
					}
				} else {
					System.out.println(" :-enter proper designation choice-: ");
					d = 0;
				}

			}
		}

		//li.add(new Employee(0, eName, eAge, eDesignation, eSalary));
		Operations.operations(new Employee(0, eName, eAge, eDesignation, eSalary));
		
	}
}
