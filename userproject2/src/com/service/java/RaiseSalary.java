package com.service.java;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.entity.pojo.User;
import com.jdbc.java.FetchUserData;
import com.jdbc.java.UpdateUserSalary;

public class RaiseSalary {
	public static List<User> rList;

	public static void raiseSalary() throws ClassNotFoundException, SQLException {

		rList = FetchUserData.fetchUserData();
		Scanner sc = new Scanner(System.in);
		String uid = null;
		String name = null;
		int countOfRecord = rList.size();

		if (countOfRecord == 0) {
			System.out.println("no record");
		} else {

			// UserId validation
			int uidWhile = 0;
			while (uidWhile == 0) {
				System.out.println("enter Id ");
				uid = sc.nextLine();
				if (uid.matches("[0-9]+")) {
					uidWhile++;

				} else {
					System.out.println("enter proper input ");
				}
			}

			// validating user name and id
			int nameWhile = 0;
			while (nameWhile == 0) {

				System.out.println("enter name ");
				name = sc.nextLine();

				if (name.matches("[A-Za-z]+")) {
					nameWhile++;
					// System.out.println("m.matches()");
				} else {

					System.out.println("only use alphabhets");
				}

			}

			Iterator i = rList.iterator();
			int count = 0;
			while (i.hasNext()) {

				User user = (User) i.next();
//				System.out.println(user.getUid());
//				System.out.println(user.getName());
				// String userids = String.valueOf(user.getUid());

				if (user.getUid() == Integer.valueOf(uid) && user.getName().equals(name)) {
					count++;
					int c = 0;
					while (c == 0) {
						System.out.println("how much percent salary to be raised");
						String raise = sc.nextLine();
						if (raise.matches("[0-9]+")) {
							int r = Integer.valueOf(raise);
							long amount = user.getSalary();
//						System.out.println("previous : "+amount);
//						System.out.println("percentage : "+r);
							long find = (amount / 100) * r;
							// System.out.println(find);

							c++;
							UpdateUserSalary.updateUserSalary(Integer.valueOf(uid), (find + amount));

						}

						else {
							System.out.println("enter in number");

						}
					}

				}

			}

			if (count == 0) {
				System.out.println("wrong credentials");
			}

		}
		rList.clear();

	}

}
