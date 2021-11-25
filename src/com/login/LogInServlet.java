package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		// HTML name calling...
		String hname = request.getParameter("name");
		String hpwd = request.getParameter("password");
		System.out.println(hname+" "+hpwd);
		// Connection with database....
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jmztech","root","abhik12345");
			stmt = con.createStatement();
			rs=stmt.executeQuery("SELECT username,password FROM emplogin where username='"+hname+"' and  password='"+hpwd+"'");
			
			if(rs.next()) {
				response.sendRedirect("HTML/Website.html");
//				pw.println("<html lang=\"en\">\r\n"
//						+ "<head>\r\n"
//						+ "    <style>\r\n"
//						+ "        body{\r\n"
//						+ "            background-color: aqua;\r\n"
//						+ "            color: rgb(8, 80, 80);\r\n"
//						+ "            text-align: center;\r\n"
//						+ "            font-size: large;\r\n"
//						+ "        }\r\n"
//						+ "    </style>\r\n"
//						+ "</head>\r\n"
//						+ "<body>\r\n"
//						+ "    <h1> Mission Accomplished...........</h1>\r\n"
//						+ "</body>\r\n"
//						+ "</html>");
			}
			else {
				response.sendRedirect("HTML/Login.html");
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("Connection problem : ClassNotFound");
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("Connection problem : SQLException");
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		// fetching data from html
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("password");
		String address = request.getParameter("address");
		String contract = request.getParameter("contract");
		
//		pw.println(fname + " "+lname + " "+uname + " "+pwd + " "+address + " "+contract);
		// Connection with database
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jmztech","root","abhik12345");
		pst=con.prepareStatement("insert into emplogin values(null,?,?,?,?,?,?)");
		pst.setString(1, fname);
		pst.setString(2, lname);
		pst.setString(3, uname);
		pst.setString(4, pwd);
		pst.setString(5, address);
		pst.setString(6, contract);
		
		int ps=pst.executeUpdate();
		if(ps==1) {
			pw.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <style>\r\n"
					+ "        body{\r\n"
					+ "            background-color: aqua;\r\n"
					+ "            color: rgb(8, 80, 80);\r\n"
					+ "            text-align: center;\r\n"
					+ "            font-size: large;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <h1>Mission Accomplished...........</h1>\r\n"
					+ "    <br>\r\n"
					+ "    <h2>Data Successfully inserted.....</h2>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			}
		else {
			pw.println("Employee addresss data insertion failed...");
			}
		}catch (Exception e) {
			e.printStackTrace();
			pw.println("Facing problem to connect");
			}
		
	}

}
