package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.java.UserConnection;


public class Delete extends HttpServlet {
	static Connection con;
	static Statement st  = UserConnection.st;
	static Statement st1  = UserConnection.st;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<style>\n"
				+ "body {font-family: Arial, Helvetica, sans-serif;}\n"
				+ "* {box-sizing: border-box}\n"
				+ "\n"
				+ "/* Full-width input fields */\n"
				+ "input[type=text] {\n"
				+ "  width: 100%;\n"
				+ "  padding: 15px;\n"
				+ "  margin: 5px 0 22px 0;\n"
				+ "  display: inline-block;\n"
				+ "  border: none;\n"
				+ "  background: #f1f1f1;\n"
				+ "}\n"
				+ "\n"
				+ "input[type=text]:focus {\n"
				+ "  background-color: #ddd;\n"
				+ "  outline: none;\n"
				+ "}\n"
				+ "\n"
				+ "hr {\n"
				+ "  border: 1px solid #f1f1f1;\n"
				+ "  margin-bottom: 25px;\n"
				+ "}\n"
				+ "\n"
				+ "/* Set a style for all buttons */\n"
				+ "button {\n"
				+ "  background-color: #04AA6D;\n"
				+ "  color: white;\n"
				+ "  padding: 14px 20px;\n"
				+ "  margin: 8px 0;\n"
				+ "  border: none;\n"
				+ "  cursor: pointer;\n"
				+ "  width: 100%;\n"
				+ "  opacity: 0.9;\n"
				+ "}\n"
				+ "\n"
				+ "button:hover {\n"
				+ "  opacity:1;\n"
				+ "}\n"
				+ "\n"
				+ "\n"
				+ "\n"
				+ "/* Float cancel and signup buttons and add an equal width */\n"
				+ ".cancelbtn, .signupbtn {\n"
				+ "  float: left;\n"
				+ "  width: 50%;\n"
				+ "}\n"
				+ "\n"
				+ "/* Add padding to container elements */\n"
				+ ".container {\n"
				+ "  padding: 16px;\n"
				+ "}\n"
				+ "\n"
				+ "/* Clear floats */\n"
				+ ".clearfix::after {\n"
				+ "  content: \"\";\n"
				+ "  clear: both;\n"
				+ "  display: table;\n"
				+ "}\n"
				+ "\n"
				+ "</style>\n"
				+ "<body>\n"
				+ "\n"
				+ "<form action=\"Delete\" style=\"border:1px solid #ccc\" method=\"Post\">\n"
				+ "  <div class=\"container\">\n"
				+ "    <h1>Deletion Form</h1>\n"
				+ "    \n"
				+ "    <hr>\n"
				+ "\n"
				+ "    <label for=\"id\"><b>User ID</b></label>\n"
				+ "    <input type=\"text\" placeholder=\"Enter Deletion Id\" name=\"id\">\n"
				+ "\n"
				+ "\n"
				+ "    <div class=\"clearfix\">\n"
				+ "     \n"
				+ "      <button style=\"background-color:red;\" type=\"reset\" class=\"cancelbtn\">Reset</button>\n"
				+ "      <button type=\"submit\" class=\"signupbtn\">Delete</button>\n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</form>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>");;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("in deletion do post");
		con = UserConnection.con;
//		Cookie cookie1 = new Cookie("deletionId",request.getParameter("id"));
//		response.addCookie(cookie1);
		
		 try {
			
			 st.execute("delete from core.designation where userId='"+request.getParameter("id")+"'");
			 st1.execute("delete from core.userData where userId ='"+request.getParameter("id")+"'");
				RequestDispatcher rd = request.getRequestDispatcher("DisplayOption");
				rd.forward(request, response);
		} catch (SQLException e) {
			PrintWriter pw = response.getWriter();
			pw.print("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<body style=\"background-color:powderblue;\">\n"
					+ "\n"
					+ "<h1>Deletion UnSuccessful</h1>\n"
					+ "\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
		}
		
		 System.out.println("deletion sucessful");
	}

}
