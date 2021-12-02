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

import com.jdbc.java.Connections;
import com.jdbc.java.UserConnection;

public class Delete extends HttpServlet {
	static Connection con;
	static Statement st = Connections.st;
	static Statement st1 = Connections.st;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("in deletion do post");
		con = Connections.con;

		try {

			st.execute("delete from core.designation where userId='" + request.getParameter("id") + "'");
			st1.execute("delete from core.userData where userId ='" + request.getParameter("id") + "'");
			response.sendRedirect("jsp/DisplayOption.jsp");

		} catch (SQLException e) {
			PrintWriter pw = response.getWriter();
			pw.print("<!DOCTYPE html>\n" + "<html>\n" + "<body style=\"background-color:powderblue;\">\n" + "\n"
					+ "<h1>Deletion UnSuccessful</h1>\n" + "\n" + "\n" + "</body>\n" + "</html>");
		}

		System.out.println("deletion sucessful");
	}

}
