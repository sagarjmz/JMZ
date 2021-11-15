package com.jmz.anand;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jmz.jdbc.Jdbc_Fetch_Class;
import com.jmz.jdbc.Jdbc_Update_Class;

public class RaiseSalary {
	public static List<User> lis;

	static String uid;
	static String empname;
	static int usalary;
	static Scanner sc1 = new Scanner(System.in);

	public static void raiseSalary() throws Exception {
		lis = Jdbc_Fetch_Class.fetch();
//		System.out.println(lis);
		User user = null;
		// System.out.println(lis);
//			Iterator l;
//			l = lis.iterator();
//			while (l.hasNext()) {
//				if(lis.size()!=0) {
//				lis = (List) l.next();
//				 //System.out.println(l);
//			}else {
//				System.out.println("no records");
//			}
//		}
		if (lis.size() == 0) {
			System.out.println("no records");
		} else {

//				uid=user.empid;
//				empname=user.name;
			int a = 0;
			while (a == 0) {
				int a1 = 0;
				while (a1 == 0) {
					System.out.println("enter id ");
					uid = sc1.nextLine();
					if (uid.matches("^[0-9]+$")) {
						a1++;
					} else {
						System.out.println("enter oly numbers");
					}
				}

				int b1 = 0;
				while (b1 == 0) {
					System.out.println("enter name");
					empname = sc1.nextLine();
					if (empname.matches("^[A-Za-z\\s]+$")) {
						b1++;
					} else {
						System.out.println("enter only alphabets");
					}
				}
				Iterator<User> i = lis.iterator();
				while (i.hasNext()) {
					user = (User) i.next();

					if (user.getEmpid() == Integer.valueOf(uid) && user.getName().equals(empname)) {
						String z = null;
						Integer z1 = null;

						int y = 0;

						while (y == 0) {
							System.out.println("enter percentage to increase");
							try {
								Scanner sc1 = new Scanner(System.in);
								z = sc1.next();
								z1 = Integer.valueOf(z);
							} catch (Exception e) {
								System.out.println();
							} finally {
								if (z.matches("^[0-9]+$")) {
									usalary = (user.getSalary() + (user.getSalary() * z1) / 100);
									user.setSalary(usalary);
									System.out.println(usalary);
									Jdbc_Update_Class.update(uid, usalary);
									y++;
									a++;
								} else {
									System.out.println("enter integer oly");
									y = 0;
								}

							}y++;

						}

					}

				}
			}

		}
	}
}
