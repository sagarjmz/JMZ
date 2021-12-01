package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.java.UserConnection;


public class CreateUser extends HttpServlet {
	static Connection con = UserConnection.con;
	static PreparedStatement pst = null;
	static PreparedStatement pst1 = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equals("POST")) {

		
			doPost(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.print("<!DOCTYPE html>\n" + "<html>\n" + "<style>\n" + "input[type=text], select {\n"
					+ "  width: 100%;\n" + "  padding: 12px 20px;\n" + "  margin: 8px 0;\n"
					+ "  display: inline-block;\n" + "  border: 1px solid #ccc;\n" + "  border-radius: 4px;\n"
					+ "  box-sizing: border-box;\n" + "}\n" + "\n" + "input[type=submit] {\n" + "  width: 100%;\n"
					+ "  background-color: #4CAF50;\n" + "  color: white;\n" + "  padding: 14px 20px;\n"
					+ "  margin: 8px 0;\n" + "  border: none;\n" + "  border-radius: 4px;\n" + "  cursor: pointer;\n"
					+ "}\n" + "\n" + "input[type=submit]:hover {\n" + "  background-color: #45a049;\n" + "}\n" + "\n"
					+ "\n" + "div {\n" + "  border-radius: 5px;\n" + "  background-color: #f2f2f2;\n"
					+ "  padding: 20px;\n" + "}\n" + "\n" + "input[type=reset] {\n" + "  width: 100%;\n"
					+ "  background-color: red;\n" + "  color: white;\n" + "  padding: 14px 20px;\n"
					+ "  margin: 8px 0;\n" + "  border: none;\n" + "  border-radius: 4px;\n" + "  cursor: pointer;\n"
					+ "}\n" + "\n" + "input[type=reset]:hover {\n" + "  background-color: reds;\n" + "}\n"
					+ "</style>\n" + "<body>\n" + "\n" + "<h3>Create User Form</h3>\n" + "\n" + "<div>\n"
					+ "  <form action=\"CreateUser\" method=Post>\n"
					+ "    <label for=\"fname\">Enter Full Name</label>\n"
					+ "    <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"Your name..\">\n" + "\n"
					+ "    <label for=\"lname\">Enter Age</label>\n"
					+ "    <input type=\"text\" id=\"lname\" name=\"age\" placeholder=\"Your Age..\">\n"
					+ "      <label for=\"des\">Enter Designation</label>\n"
					/* + "    <input type=\"text\" id=\"des\" name=\"des\" placeholder=\"Your Designation..\">\n" + "\n"*/
                    +" <select id=\"des\" name=\"des\">\n"
                    + "  <option value=\"Programmer\">Programmer</option>\n"
                    + "  <option value=\"Tester\">Tester</option>\n"
                    + "  <option value=\"Manager\">Manager</option>"+"\n"
					+ "    \n" + "  \n" + "    <input type=\"submit\" value=\"Submit\">\n"
					+ "        <input type=\"reset\" value=\"Reset\">\n" + "  </form>\n" + "</div>\n" + "\n"
					+ "</body>\n" + "</html>\n" + "\n" + "\n" + "");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("in doPost");
		int year = YearMonth.now().getYear();
		int month = YearMonth.now().getMonthValue();

		Random r = new Random();
		int id = r.nextInt(10000);
		String fid = year + "JMZ" + month + id;
		int aSal[] = { 20000, 30000, 15000 };
		long salary = 0;

		if (request.getParameter("des").equalsIgnoreCase("Programmer")) {
			salary = aSal[0];
		} else if (request.getParameter("des").equalsIgnoreCase("Manager")) {
			salary = aSal[1];
		} else if (request.getParameter("des").equalsIgnoreCase("Tester")) {
			salary = aSal[2];
		}
		//using cookies
//		Cookie cookie = new Cookie("Cid",id+"");
//		response.addCookie(cookie);
//		Cookie cookie1 = new Cookie("designation",request.getParameter("des"));
//		response.addCookie(cookie1);
//		Cookie cookie2 = new Cookie("salary",salary+"");
//		response.addCookie(cookie2);
//		Cookie cookie3 = new Cookie("age",request.getParameter("age"));
//		response.addCookie(cookie3);
		
		try {
			pst = con.prepareStatement("insert into userData values('" + fid + "',?,?)");
			pst.setString(1, request.getParameter("fname"));
			pst.setInt(2, Integer.parseInt(request.getParameter("age")));
			pst.execute();
			pst1 = con.prepareStatement("insert into designation values(null,?,?,'" + fid + "')");
			pst1.setLong(1, salary);
			pst1.setString(2, request.getParameter("des"));
			pst1.execute();

		RequestDispatcher rd = request.getRequestDispatcher("DisplayOption");
		rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
