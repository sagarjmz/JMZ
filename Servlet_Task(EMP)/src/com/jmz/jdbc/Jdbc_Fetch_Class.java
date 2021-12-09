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
	static String url = "jdbc:mysql://localhost:3306/emp1";
	static String usr = "root";
	static String pwd = "Year@2021";
public static List<User> list=new ArrayList<User>();
	public static List<User> fetch() throws SQLException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		PreparedStatement pst = con.prepareStatement("select * from emp_table1");
		PreparedStatement pst1 = con.prepareStatement("select * from emp_table2 where emp_id=?");
		
		String name;
		String empid;
		int salary;
		String designation;
		String age;
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			empid = rs.getString("emp_id");
			name = rs.getString("emp_name");
			age = rs.getString("emp_age");
			pst1.setString(1,empid);
			ResultSet rs1 = pst1.executeQuery();
			rs1.next();
			designation = rs1.getString(2);
			salary = rs1.getInt(3);
		
			
			System.out.println("emp ID : " + empid);
			System.out.println("emp Name : " + name);
			System.out.println("emp age : " + age);
			System.out.println("emp designation : " + designation);
			System.out.println("emp salary : " + salary);
			System.out.println("---------------------");
			System.out.println("---------------------");
			list.add(new User(rs.getString("emp_id"),rs.getString("emp_name"),rs.getString("emp_age"),rs1.getString(2),rs1.getInt(3)));
		}
		return list;

	}

}
