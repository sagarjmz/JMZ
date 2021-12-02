package com.jdbc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	static Connection con =null;
	static Statement st = null;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		PrintWriter pw = response.getWriter();
		
		try {
			RequestDispatcher rd1 = request.getRequestDispatcher("Connections");
			rd1.include(request, response);
			//UserConnection.openLoginConnection();
		//	UserConnection.openConnection();
			st = Connections.con1.createStatement();
			ResultSet rs = st.executeQuery("select * from login where username='"+uname+"' and userpwd='"+pwd+"'");
			if(rs.next())
			{
//				Cookie cookie = new Cookie("loginId", uname);
//				response.addCookie(cookie);
				response.sendRedirect("jsp/DisplayOption.jsp");
			
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
