


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FetchUserData {
	static Connection con = UserConnection.con;
	static PreparedStatement pst = UserConnection.pst;

	static public List<User> list = new ArrayList<User>();

	public static List<User> fetchUserData() throws SQLException, ClassNotFoundException {

//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection(url,usr,pwd);
		pst = con.prepareStatement("select * from user");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			
			// String name, String designation, int salary, int uid, int age
			list.add(new User(rs.getString("userName"), rs.getString("userDesgination"), rs.getLong("userSalary"),
					rs.getInt("userId"), rs.getInt("userAge")));
		}

		return list;
	}

}

