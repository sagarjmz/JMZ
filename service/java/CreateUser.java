package com.service.java;


import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.entity.java.User;
import com.jdbc.java.InsertUser;

import com.entity.java.User;
import com.jdbc.java.InsertUser;

public class CreateUser {
	// static public List<User> li = new ArrayList<User>();

	static String name;
	// static String ds;
	static int age;
	static String designation;

	static int aSal[] = { 20000, 30000, 15000 };
	static long salary;
	static Scanner sc = new Scanner(System.in);

	public static void createUser() throws ClassNotFoundException, SQLException {

		int mainWhile = 0;
		String ds = null;

		// main while coding
		while (mainWhile == 0) {

			// age coding
			int ageWhile = 0;
			while (ageWhile == 0) {
				System.out.println("enter age between 18 - 60 ");
				String ageValue = sc.nextLine();
				int ages = 0;
				if (ageValue.matches("^[0-9][0-9]$")) {
					ages = Integer.valueOf(ageValue);

					if (ages >= 18 && ages <= 60) {
						// System.out.println("success");
						ageWhile++;
						age = Integer.valueOf(ageValue);
					}
				} else {
					System.out.println("enter proper input ");
				}
			}

			// name coding part
			int nameWhile = 0;
			while (nameWhile == 0) {
				int checkName = 0;

				System.out.println("enter name");
				name = sc.nextLine();
				String nameArray[] = name.split(" ");
				// CheckLenght.checkLenght(name, nameArray);
				if (nameArray.length > 3) {
					System.out.println("only 3 words allowed");
					nameWhile = 0;
				} else {
					// System.out.println("in < 3");
					for (String s : nameArray) {

						// System.out.println(s);
						// Matcher m = p.matcher(s);
						if (s.matches("[A-Za-z]+")) {
							checkName++;
							// System.out.println("m.matches()");
						}

					}
					// System.out.println(checkName);
					if (checkName == nameArray.length) {
						nameWhile = 1;
					} else {
						nameWhile = 0;
						System.out.println("only use alphabhets");
					}

				}

			}

			// designation coding part

			int desWhile = 0;
			while (desWhile == 0) {
				System.out.println("enter designation 1)programmer 2)manager 3)tester");
				// ds = sc.nextLine();
				ds = sc.nextLine();
				String temp = ds.replace(" ", ""); // split designation value

				// programmer coding
				if (temp.equalsIgnoreCase("programmer")) {
					salary = aSal[0];
					designation = "programmer";

					// y/n
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							mainWhile++;
							desWhile = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							mainWhile = 0;
							desWhile = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n");
							yn = 0;

						}
					}

				}

				// manager coding

				else if (temp.equalsIgnoreCase("manager")) {
					salary = aSal[1];
					designation = "manager";

					// y/n
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							mainWhile++;
							desWhile = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							mainWhile = 0;
							desWhile = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n");

							yn = 0;

						}
					}
				}

				// tester coding
				else if (temp.equalsIgnoreCase("tester")) {
					salary = aSal[2];
					designation = "tester";
					// y/n
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							mainWhile++;
							desWhile = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							mainWhile = 0;
							desWhile = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n");

							yn = 0;

						}
					}
				}
				// wrong desgnation coding
				else {
					System.out.println("enter proper designation choice");
					desWhile = 0; // restart main loop
				}

			}

		}

		// li.add(new User(name, designation, salary, age));

		InsertUser.insertUser(new User(name, designation, salary, age));

	}

}
