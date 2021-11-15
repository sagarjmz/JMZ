package com.jmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jmz.anand.User;

public class Jdbc_Fetch_Class {
	static Connection con;
	static Statement st;
	static String url = "jdbc:mysql://localhost:3306/emp";
	static String usr = "root";
	static String pwd = "Year@2021";
public static List<User> list=new ArrayList<User>();
	public static List<User> fetch() throws SQLException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		PreparedStatement pst = con.prepareStatement("select * from emp_table");
		ResultSet rs = pst.executeQuery();
		String name;
		int empid;
		int salary;
		String designation;
		String age;

		while (rs.next()) {
			empid = rs.getInt("emp_id");
			name = rs.getString("emp_name");
			age = rs.getString("emp_age");
			designation = rs.getString("emp_designation");
			salary = rs.getInt("emp_salary");
			System.out.println("emp ID : " + empid);
			System.out.println("emp Name : " + name);
			System.out.println("emp age : " + age);
			System.out.println("emp designation : " + designation);
			System.out.println("emp salary : " + salary);
			System.out.println("---------------------");
			System.out.println("---------------------");
			list.add(new User(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getString("emp_age"),rs.getString("emp_designation"),rs.getInt("emp_salary")));
		}
		return list;

	}

}
