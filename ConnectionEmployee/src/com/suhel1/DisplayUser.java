package com.suhel1;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class DisplayUser {
	static public List list;

	public static void displayUser() throws ClassNotFoundException, SQLException {

		list = FetchUserData.fetchUserData();

		if (list.size() != 0) {
			System.out.println("user data");
			Iterator i = list.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			System.out.println();

		} else {
			System.out.println("no record");
		}
		list.clear();
	}
}