package com.jmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jmz.anand.User;

public class Jdbc_Delete_Class {
	
	static String empid;
	static User user = null;
	static Connection con;
	static Statement st;
	static String url = "jdbc:mysql://localhost:3306/emp1";
	static String usr = "root";
	static String pwd = "Year@2021";
	public static void delete(String uid) throws Exception {
		
		empid=uid;
		//System.out.println(empid);
		String sql = "delete from emp_table2 where emp_id='"+empid+"'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
		st = con.createStatement();
		int r=st.executeUpdate(sql);
		if(r==1) {
			System.out.println("deleted");
		}else {
			System.out.println("error mention proper id");
		}
		String sql1 = "delete from emp_table1 where emp_id='"+empid+"'";
		int r1=st.executeUpdate(sql1);
		if(r1==1) {
			System.out.println("deleted");
		}else {
			System.out.println("error mention proper id");
		}
	}

}
