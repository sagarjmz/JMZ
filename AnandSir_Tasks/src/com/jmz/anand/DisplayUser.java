package com.jmz.anand;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.jmz.jdbc.Jdbc_Fetch_Class;

public class DisplayUser {
public static List list;
	public static void displayUser() throws SQLException, Exception {
		list=Jdbc_Fetch_Class.fetch();
		if (CreateUser.li.size() != 0) {

			System.out.println("user data");
			Iterator i = CreateUser.li.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		}else {
			//System.out.println("no records found");
		}
	}
}