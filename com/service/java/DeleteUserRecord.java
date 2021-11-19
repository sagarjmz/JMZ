package com.service.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.entity.java.User;
import com.jdbc.java.DeleteUser;
import com.jdbc.java.FetchUserData;


public class DeleteUserRecord {
	static List<User> list;

	public static void deleteUserRecord() throws NumberFormatException, SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String id = null;
		while (n == 0) {
			System.out.println("enter User Id");
			id = sc.nextLine();
			if (id.matches("[0-9]+")) {
				n++;

			} else {
				System.out.println("enter proper id ");
			}
		}
		list = FetchUserData.fetchUserData();
		int count = 0;
		for (User u : list) {
			String v = String.valueOf(u.getUid());
			if (v.equals(id)) {
				// System.out.println("id exist");
				// DeleteUser.deleteUser(Integer.valueOf(id));
				count++;
			}

		}
		if (count != 0) {
			DeleteUser.deleteUser(Integer.valueOf(id));
		} else {
			System.out.println("id doesnt exist");
		}

		list.clear();

	}

}
