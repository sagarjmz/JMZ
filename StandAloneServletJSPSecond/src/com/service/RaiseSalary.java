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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("salary");
		System.out.println("Id : " + id);
		int salary = Integer.parseInt(request.getParameter("salary"));
		System.out.println(salary);

		try {
			st1 = con.createStatement();

			int amount = salary;
			if (request.getParameter("p") != null) {
				long find = (amount / 100) * Integer.parseInt(request.getParameter("p"));

				st1.execute("update designation set Salary = '" + (amount + find) + "' where userId ='" + id + "'");

			}
			response.sendRedirect("jsp/DisplayOption.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
