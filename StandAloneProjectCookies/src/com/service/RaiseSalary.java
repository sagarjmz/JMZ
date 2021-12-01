package com.service;

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

import com.jdbc.java.Connections;
import com.jdbc.java.UserConnection;

public class RaiseSalary extends HttpServlet {


	static Connection con = Connections.con;
	static Statement st;
	static Statement st1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		pw.print("<!DOCTYPE html>\n" + "<html>\n" + "<style>\n" + "body {font-family: Arial, Helvetica, sans-serif;}\n"
				+ "* {box-sizing: border-box}\n" + "\n" + "/* Full-width input fields */\n" + "input[type=text] {\n"
				+ "  width: 100%;\n" + "  padding: 15px;\n" + "  margin: 5px 0 22px 0;\n" + "  display: inline-block;\n"
				+ "  border: none;\n" + "  background: #f1f1f1;\n" + "}\n" + "\n" + "input[type=text]:focus{\n"
				+ "  background-color: #ddd;\n" + "  outline: none;\n" + "}\n" + "\n" + "hr {\n"
				+ "  border: 1px solid #f1f1f1;\n" + "  margin-bottom: 25px;\n" + "}\n" + "\n"
				+ "/* Set a style for all buttons */\n" + "button {\n" + "  background-color: #04AA6D;\n"
				+ "  color: white;\n" + "  padding: 14px 20px;\n" + "  margin: 8px 0;\n" + "  border: none;\n"
				+ "  cursor: pointer;\n" + "  width: 100%;\n" + "  opacity: 0.9;\n" + "}\n" + "\n" + "button:hover {\n"
				+ "  opacity:1;\n" + "}\n" + "\n" + "/* Extra styles for the cancel button */\n" + ".cancelbtn {\n"
				+ "  padding: 14px 20px;\n" + "  background-color: #f44336;\n" + "}\n" + "\n"
				+ "/* Float cancel and signup buttons and add an equal width */\n" + ".cancelbtn, .signupbtn {\n"
				+ "  float: left;\n" + "  width: 50%;\n" + "}\n" + "\n" + "/* Add padding to container elements */\n"
				+ ".container {\n" + "  padding: 16px;\n" + "}\n" + "\n" + "/* Clear floats */\n"
				+ ".clearfix::after {\n" + "  content: \"\";\n" + "  clear: both;\n" + "  display: table;\n" + "}\n"
				+ "\n" + "/* Change styles for cancel button and signup button on extra small screens */\n"
				+ "@media screen and (max-width: 300px) {\n" + "  .cancelbtn, .signupbtn {\n" + "     width: 100%;\n"
				+ "  }\n" + "}\n" + "</style>\n" + "<body>\n" + "\n"
				+ "<form action=\"RaiseSalary\" style=\"border:1px solid #ccc\" method=post>"
				+ "  <div class=\"container\">\n" + "    <h1>Updation Form</h1>\n" + "    <hr>\n" + "\n"
				+ "    <label for=\"uid\"><b>User ID</b></label>\n"
				+ "    <input type=\"text\" placeholder=\"Enter User Id\" name=\"uid\" required>\n" + "\n"
				+ "    <label for=\"psd\"><b>User Name</b></label>\n"
				+ "    <input type=\"text\" placeholder=\"Enter User Name\" name=\"psd\" required>\n" + "\n" + " \n"
				+ "\n" + "    <div class=\"clearfix\">\n"
				+ "      <button type=\"reset\" class=\"cancelbtn\">Reset</button>\n"
				+ "      <button type=\"submit\" class=\"signupbtn\">Check</button>\n" + "    </div>\n" + "  </div>\n"
				+ "</form>\n" + "\n" + "</body>\n" + "</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String psd = request.getParameter("psd");
		HttpSession session = request.getSession();
		try {
			st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from Core.userData where userId='" + uid + "' and userName='" + psd + "'");

			if (rs.next()) {
				session.setAttribute("id", rs.getString(1));
				st1 = con.createStatement();
				ResultSet rs1 = st.executeQuery("select salary from designation where userId='" + uid + "'");
				if (rs1.next()) {
					session.setAttribute("salary", rs1.getInt("salary"));

				}

				PrintWriter pw = response.getWriter();
				pw.print("<!DOCTYPE html>\n" + "<html>\n" + "<style>\n"
						+ "body {font-family: Arial, Helvetica, sans-serif;}\n" + "* {box-sizing: border-box}\n" + "\n"
						+ "/* Full-width input fields */\n" + "input[type=text] {\n" + "  width: 100%;\n"
						+ "  padding: 15px;\n" + "  margin: 5px 0 22px 0;\n" + "  display: inline-block;\n"
						+ "  border: none;\n" + "  background: #f1f1f1;\n" + "}\n" + "\n" + "input[type=text]:focus{\n"
						+ "  background-color: #ddd;\n" + "  outline: none;\n" + "}\n" + "\n" + "hr {\n"
						+ "  border: 1px solid #f1f1f1;\n" + "  margin-bottom: 25px;\n" + "}\n" + "\n"
						+ "/* Set a style for all buttons */\n" + "button {\n" + "  background-color: #04AA6D;\n"
						+ "  color: white;\n" + "  padding: 14px 20px;\n" + "  margin: 8px 0;\n" + "  border: none;\n"
						+ "  cursor: pointer;\n" + "  width: 100%;\n" + "  opacity: 0.9;\n" + "}\n" + "\n"
						+ "button:hover {\n" + "  opacity:1;\n" + "}\n" + "\n"
						+ "/* Extra styles for the cancel button */\n" + ".cancelbtn {\n" + "  padding: 14px 20px;\n"
						+ "  background-color: #f44336;\n" + "}\n" + "\n"
						+ "/* Float cancel and signup buttons and add an equal width */\n"
						+ ".cancelbtn, .signupbtn {\n" + "  float: left;\n" + "  width: 50%;\n" + "}\n" + "\n"
						+ "/* Add padding to container elements */\n" + ".container {\n" + "  padding: 16px;\n" + "}\n"
						+ "\n" + "/* Clear floats */\n" + ".clearfix::after {\n" + "  content: \"\";\n"
						+ "  clear: both;\n" + "  display: table;\n" + "}\n" + "\n"
						+ "/* Change styles for cancel button and signup button on extra small screens */\n"
						+ "@media screen and (max-width: 300px) {\n" + "  .cancelbtn, .signupbtn {\n"
						+ "     width: 100%;\n" + "  }\n" + "}\n" + "</style>\n" + "<body>\n" + "\n"
						+ "<form action=\"RaiseSalary\" style=\"border:1px solid #ccc\" method=post>\n"
						+ "  <div class=\"container\">\n" + "    <h1>Updation Form</h1>\n" + "    <hr>\n" + "\n" + "\n"
						+ "    <label for=\"psd\"><b>Hike percentage</b></label>\n"
						+ "    <input type=\"text\" placeholder=\"Enter percentage\" name=\"p\" >\n" + "\n" 
						 
						+ "\n" + "    <div class=\"clearfix\">\n"
						+ "      <button type=\"reset\" class=\"cancelbtn\">Reset</button>\n"
						+ "      <button type=\"submit\" class=\"signupbtn\">Check</button>\n" + "    </div>\n"
						+ "  </div>\n" + "</form>\n" + "\n" + "</body>\n" + "</html>");

			}
			else
			{
			//System.out.println("wrong credencial");
				RequestDispatcher rd = request.getRequestDispatcher("DisplayOption");
				rd.forward(request, response);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (session.getAttribute("id") != null) {
			int count=0;
			try {
				st1 = con.createStatement();
				HttpSession session1 = request.getSession();
				int amount = (int) session1.getAttribute("salary");
				if (request.getParameter("p") != null) {
					long find = (amount / 100) * Integer.parseInt(request.getParameter("p"));

					st1.execute("update designation set Salary = '" + (amount + find) + "' where userId ='"
							+ session.getAttribute("id") + "'");
					count++;
				
				}
//				if(count != 0)
//				{
//					RequestDispatcher rd = request.getRequestDispatcher("DisplayOption");
//					rd.forward(request, response);
//				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
