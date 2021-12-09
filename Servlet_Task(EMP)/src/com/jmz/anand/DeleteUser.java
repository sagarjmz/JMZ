package com.jmz.anand;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jmz.jdbc.Jdbc_Delete_Class;
import com.jmz.jdbc.Jdbc_Fetch_Class;

public class DeleteUser {
	public static List<User> lis;

	static String uid;
	static Scanner sc = new Scanner(System.in);

	public static void deleteUser() throws Exception {
		lis = Jdbc_Fetch_Class.fetch();

		if (lis.size() == 0) {
			System.out.println("no records");
		} else {

//			int a1 = 0;
//			while (a1 == 0) {
				System.out.println("enter id to delete");
				uid = sc.nextLine();
//			}
			Jdbc_Delete_Class.delete(uid);
		}
	}
}
