package com.jmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.YearMonth;
import java.util.Iterator;

import com.jmz.anand.CreateUser;
import com.jmz.anand.User;

public class Jdbc_Insert_Class {
	static String empid;
	static String name;
	static String age;
	static String designation;
	static int salary;
	static User user = null;
	static Connection con;
	static PreparedStatement pst;
	static PreparedStatement pst1;
	static String url = "jdbc:mysql://localhost:3306/emp1";
	static String usr = "root";
	static String pwd = "Year@2021";
	static String sql = "insert into emp_table1 values(?,?,?)";
	static String sql1 = "insert into emp_table2 values(null,?,?,?)";

	public static void insert(User user) throws Exception {
		int min = 100;  
		int max = 999; 
		int yr = YearMonth.now().getYear();
		int month = YearMonth.now().getMonthValue();
		double empid1=Math.random()*(max-min+1)+min; 
		int eid = (int) Math.round(empid1);
		String empid=Integer.toString(yr) + "JMZ" + Integer.toString(month) + Integer.toString(eid) ;
		name = user.getName();
		age = user.getAge();
		designation = user.getDesignation();
		salary = user.getSalary();
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		pst = con.prepareStatement(sql);
		pst.setString(1, empid);
		pst.setString(2, name);
		pst.setString(3, age);
		pst1=con.prepareStatement(sql1);
		pst1.setString(1, designation);
		pst1.setInt(2, salary);
		pst1.setString(3, empid);
		int r = pst.executeUpdate();
		if (r == 1) {
			System.out.println("sucess");
		} else {
			System.out.println("unsucessfull");
		}
		int r1 = pst1.executeUpdate();
		if (r1 == 1) {
			System.out.println("sucess");
		} else {
			System.out.println("unsucessfull");
		}
	}
}
