package Java_Classes;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.ValueExp;
import javax.xml.validation.Validator;

import jdbcpro.Insertdata;

public class CreateUser {
	public static List li = new ArrayList();
	static String name;
	static String age;
	static String designation;
	static int aSal[] = { 20000, 30000, 15000 };
	static int salary;
	static Scanner sc = new Scanner(System.in);

	public static void createUser() throws Exception {
		User user;
		int c = 0;
		while (c == 0) {
			int a = 0;
			do {
				System.out.println("enter name");
				name = sc.nextLine();
				String[] s = name.split(" ");
				String regex = "^[A-Za-z\\s]+$";
				
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(name);
				if (m.matches()) {
					a++;
				} else {
					System.out.println("name should contain only alphabets");
				}
				if (s.length > 3) {
					System.out.println("Maximum three words allowed");
					a = 0;
				}				
			} while (a == 0);
			int aa = 0;
			while (aa == 0) {
			System.out.println("enter age");
			Scanner sc1 = new Scanner(System.in);
			age = sc1.next();
			// age = Integer.valueOf(age);
			String agecheck = "^[0-9]+$";
			Pattern p1 = Pattern.compile(agecheck);
			Matcher m1 = p1.matcher(String.valueOf(age));
			if (m1.matches()) {
			aa++;
			if ((Integer.valueOf(age) > 18) && (Integer.valueOf(age) <= 60)) {
				
				
			//System.out.println("proper age");
			} else {
			System.out.println("Enter age between 18 to 60");
			aa=0;
			}
			} else {
			System.out.println("Only integer allowed");
			}
			}

			/*
			 * int ag = 0; Scanner sc1 = new Scanner(System.in); while (ag == 0) {
			 * System.out.println("enter age"); age = sc1.nextInt(); if (age > 60) {
			 * System.out.println("Enter age between 18 to 60"); ag = 0; } else if (age <
			 * 18) { System.out.println("Enter age between 18 to 60"); ag = 0; } else {
			 * ag++; } }
			 */
			int b = 0;
			while (b == 0) {
				System.out.println("enter designation 1)programmer 2)manager 3)tester");
				String ds = sc.nextLine().replace(" ", "");
				if (ds.equalsIgnoreCase("programmer")) {
					salary = aSal[0];
					designation = "programmer";
					int d = 0;
					while (d == 0) {
						System.out.println("enter y to save or n to not save");
						String val = sc.nextLine();
						if (val.equals("n")) {
							c = 0;
							d++;
							b++;
						} else if (val.equals("y")) {
							c++;
							b++;
							d++;
						} else {
							System.out.println("enter within y/n");
						}
					}
				} else if (ds.equalsIgnoreCase("manager")) {
					salary = aSal[1];
					designation = "manager";
					int d = 0;
					while (d == 0) {
						System.out.println("enter y to save or n to not save");
						String val = sc.nextLine();
						if (val.equals("n")) {
							c = 0;
							d++;
							b++;
						} else if (val.equals("y")) {
							c++;
							b++;
							d++;
						} else {
							System.out.println("enter within y/n");
						}
					}
				} else if (ds.equalsIgnoreCase("tester")) {
					salary = aSal[2];
					designation = "tester";
					int d = 0;
					while (d == 0) {
						System.out.println("enter y to save or n to not save");
						String val = sc.nextLine();
						if (val.equals("n")) {
							c = 0;
							d++;
							b++;
						} else if (val.equals("y")) {
							c++;
							b++;
							d++;
						} else {
							System.out.println("enter within y/n");
						}
					}
				} else {
					System.out.println("enter proper designation choice");
				}
			}
		}
		li.add(new User(name, age, designation, salary));
		Insertdata.insert(new User(name,age,designation,salary));
	}
}

