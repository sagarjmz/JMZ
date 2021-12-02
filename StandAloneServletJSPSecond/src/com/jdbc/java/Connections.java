package com.jdbc.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connections
 */
public class Connections extends HttpServlet {
	public static Connection con;
	public static Statement st;
	static Connection con1 ;
	static Statement st1 ;
	static PreparedStatement pst;
//	static String usr = "root";
//	static String pwd = "prabhakar";
//	static String url = "jdbc:mysql://localhost:3306/Core";

	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
	String usr = config.getInitParameter("usr");
	String pwd = config.getInitParameter("pwd");
	String url = config.getInitParameter("url");
	String driver = config.getInitParameter("driver");
	
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,usr, pwd);
		st= con.createStatement();
		System.out.println("DB connection established Using ServletConfig");
		
		Class.forName(driver);
		con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login",usr,pwd);
		System.out.println("login connection established  Using ServletConfig");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


}
