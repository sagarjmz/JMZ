package jdbcpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;

import Java_Classes.User;


public class Insertdata {
	static int empid;
	static String name;
	static String age;
	static String designation;
	static int salary;
	static User user = null;
	static Connection con;
	static PreparedStatement pst;
	static String url = "jdbc:mysql://localhost:3306/hpdata";
	static String usr = "root";
	static String pwd = "tiger";
	static String sql = "insert into student values(?,?,?,?,?)";

	public static void insert(User user) throws Exception {
		empid = user.getEmpid();
		name = user.getName();
		age = user.getAge();
	//	System.out.println(age);
		designation = user.getDesignation();
		salary = user.getSalary();
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		pst = con.prepareStatement(sql);
		pst.setInt(1, empid);
		pst.setString(2, name);
		pst.setString(3, age);
		pst.setString(4, designation);
		pst.setInt(5, salary);
		int r = pst.executeUpdate();
		if (r == 1) {
			System.out.println("success");
		} else {
			System.out.println("unsucessfull");
		}
	}
}
