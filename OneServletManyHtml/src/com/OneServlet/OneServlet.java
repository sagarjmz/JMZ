package com.OneServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneServlet extends HttpServlet
{
	static Connection con =null;
	static Statement st = null;
	public static void openConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","prabhakar");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		PrintWriter pw = response.getWriter(); 
		
		try {
			openConnection();
			st = con.createStatement();
			int res = st.executeUpdate("insert into login values('"+uname+"','"+pwd+"')");
			if(res == 1)
			{
				pw.print("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<body style=\"background-color:powderblue;\">\n"
						+ "\n"
						+ "<h1>Insertion Successful</h1>\n"
						+ "\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>");
			}
			else
			{
				pw.print("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<body style=\"background-color:powderblue;\">\n"
						+ "\n"
						+ "<h1>Insertion UnSuccessful</h1>\n"
						+ "\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		PrintWriter pw = response.getWriter();
		
		try {
			openConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login where username='"+uname+"' and userpwd='"+pwd+"'");
			if(rs.next())
			{
				pw.print("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<body style=\"background-color:MediumSeaGreen;\">\n"
						+ "\n"
						+ "<h1>Login Successful</h1>\n"
						+ "\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>");
			}
			else
			{
				pw.print("<!DOCTYPE html>\n"
						+ "<html>\n"
						+ "<body style=\"background-color:Tomato;\">\n"
						+ "\n"
						+ "<h1>Login UnSuccessful</h1>\n"
						+ "\n"
						+ "\n"
						+ "</body>\n"
						+ "</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
