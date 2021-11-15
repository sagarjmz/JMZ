package com.suhel1;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RaiseSalary {
	public static List<User> rList;

	public static void raiseSalary() throws ClassNotFoundException, SQLException {

		rList = FetchUserData.fetchUserData();
		Scanner sc = new Scanner(System.in);
		String uid = null;
		String name = null;
		int count = rList.size();

		if (count == 0) {
			System.out.println(" :-no record-: ");
		} else {

			
			int g = 0;
			while (g == 0) {
				System.out.println("enter Id : ");
				uid = sc.nextLine();
				if (uid.matches("[0-9]+")) {
					g++;

				} else {
					System.out.println(" :-enter proper input-: ");
				}
			}

			
			int h = 0;
			while (h == 0) {

				System.out.println("enter Name : ");
				name = sc.nextLine();

				if (name.matches("[A-Za-z]+")) {
					h++;
					
				} else {

					System.out.println(" :-only use alphabhets-:");
				}

			}

			Iterator i = rList.iterator();
			int count1 = 0;
			while (i.hasNext()) {

				User user = (User) i.next();


				if (user.getUid() == Integer.valueOf(uid) && user.getName().equals(name)) {
					count1++;
					int c = 0;
					while (c == 0) {
						System.out.println("how much percent salary to be raised : ");
						String raise = sc.nextLine();
						if (raise.matches("[0-9]+")) {
							int r = Integer.valueOf(raise);
							long amount = user.getSalary();

							long find = (amount / 100) * r;


							c++;
							UpdateUserSalary.updateUserSalary(Integer.valueOf(uid), (find + amount));

						}

						else {
							System.out.println(" :-enter in number-: ");

						}
					}

				}

			}

			if (count1 == 0) {
				System.out.println(" :-wrong credentials-: ");
			}

		}
		rList.clear();

	}

}
