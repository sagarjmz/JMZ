package com.jmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;

import com.jmz.anand.CreateUser;
import com.jmz.anand.User;

public class Jdbc_Insert_Class {
	static int empid;
	static String name;
	static String age;
	static String designation;
	static int salary;
	static User user = null;
	static Connection con;
	static PreparedStatement pst;
	static String url = "jdbc:mysql://localhost:3306/emp";
	static String usr = "root";
	static String pwd = "Year@2021";
	static String sql = "insert into emp_table values(?,?,?,?,?)";

	public static void insert(User user) throws Exception {
		empid = user.getEmpid();
		name = user.getName();
		age = user.getAge();
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
			System.out.println("sucess");
		} else {
			System.out.println("unsucessfull");
		}
	}
}
