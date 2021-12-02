package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.java.Connections;
import com.jdbc.java.UserConnection;

public class CreateUser extends HttpServlet {
	static Connection con = Connections.con;
	static PreparedStatement pst = null;
	static PreparedStatement pst1 = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
	System.out.println("In Create");
		int year = YearMonth.now().getYear();
		int month = YearMonth.now().getMonthValue();

		Random r = new Random();
		int id = r.nextInt(10000);
		String fid = year + "JMZ" + month + id;
		int aSal[] = { 20000, 30000, 15000 };
		long salary = 0;
		ServletContext context = getServletContext();
		System.out.println(context.getInitParameter("programmer"));
		System.out.println(context.getInitParameter("manager"));
		System.out.println(context.getInitParameter("tester"));

		if (request.getParameter("des").equalsIgnoreCase("Programmer")) {
			salary = Integer.parseInt(context.getInitParameter("programmer"));
		} else if (request.getParameter("des").equalsIgnoreCase("Manager")) {
			salary = Integer.parseInt(context.getInitParameter("manager"));
		} else if (request.getParameter("des").equalsIgnoreCase("Tester")) {
			salary = Integer.parseInt(context.getInitParameter("tester"));
		}


		try {
			pst = con.prepareStatement("insert into userData values('" + fid + "',?,?)");
			pst.setString(1, request.getParameter("fname"));
			pst.setInt(2, Integer.parseInt(request.getParameter("age")));
			pst.execute();
			pst1 = con.prepareStatement("insert into designation values(null,?,?,'" + fid + "')");
			pst1.setLong(1, salary);
			pst1.setString(2, request.getParameter("des"));
			pst1.execute();

			RequestDispatcher rd = request.getRequestDispatcher("jsp/DisplayOption.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}