package com.suhel1;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class CreateUser {
	

	static String name;
	// static String ds;
	static int age;
	static String designation;

	static int aSal[] = { 20000, 30000, 15000 };
	static long salary;
	static Scanner sc = new Scanner(System.in);

	public static void createUser() throws ClassNotFoundException, SQLException {

		int a = 0;
		String ds = null;

		
		while (a == 0) {

			
			int b = 0;
			while (b == 0) {
				int checkName = 0;

				System.out.println(" enter Name : ");
				name = sc.nextLine();
				String nameArray[] = name.split(" ");
				
				if (nameArray.length > 3) {
					System.out.println(" :-only 3 words allowed-: ");
					b = 0;
				} else {
					
					for (String s : nameArray) {
						
						if (s.matches("[A-Za-z]+")) {
							checkName++;
							
						}

					}
					if (checkName == nameArray.length) {
						b = 1;
					} else {
						b = 0;
						System.out.println(" -:only use alphabhets:- ");
					}

				}

			}
		
						int c = 0;
						while (c == 0) {
							System.out.println(" enter Age:  ");
							String ageValue = sc.nextLine();
							int ages = 0;
							if (ageValue.matches("^[0-9][0-9]$")) {
								ages = Integer.valueOf(ageValue);

								if (ages >= 18 && ages <= 60) {
									
									c++;
									age = Integer.valueOf(ageValue);
								}
							} else {
								System.out.println(" :-enter proper input-: ");
							}
						}

			

			int d = 0;
			while (d == 0) {
				System.out.println("enter designation 1)programmer 2)manager 3)tester : ");
				
				ds = sc.nextLine();
				String temp = ds.replace(" ", "");

				
				if (temp.equalsIgnoreCase("programmer")) {
					salary = aSal[0];
					designation = "programmer";

				
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n : ");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							a++;
							d = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							a = 0;
							d = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n : ");
							yn = 0;

						}
					}

				}

				

				else if (temp.equalsIgnoreCase("manager")) {
					salary = aSal[1];
					designation = "manager";

					
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n : ");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							a++;
							d = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							a = 0;
							d = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n : ");

							yn = 0;

						}
					}
				}

				
				else if (temp.equalsIgnoreCase("tester")) {
					salary = aSal[2];
					designation = "tester";
					
					int yn = 0;
					while (yn == 0) {
						System.out.println("enter y or n : ");
						String val = sc.nextLine();
						if (val.equalsIgnoreCase("n")) {
							a++;
							d = 1;
							yn = 1;
						} else if (val.equalsIgnoreCase("y")) {
							a = 0;
							d = 1;
							yn = 1;
						} else {
							System.out.println("enter y/n : ");

							yn = 0;

						}
					}
				}
				
				else {
					System.out.println(" :-enter proper designation choice-: ");
					d = 0; // restart main loop
				}

			}

		}

	

		InsertUser.insertUser(new User(name, designation, salary, age));

	}

}
