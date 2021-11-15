package Java_Classes;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import jdbcpro.Jdbc_Fetch_Data;

public class DisplayUser {
	public static List list;

	public static void displayUser() throws SQLException, Exception {
		list = Jdbc_Fetch_Data.fetch();
		if (CreateUser.li.size() != 0) {
			System.out.println("user data");
			Iterator i = CreateUser.li.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		} else {
//			System.out.println("no data");
		}
	}
}
