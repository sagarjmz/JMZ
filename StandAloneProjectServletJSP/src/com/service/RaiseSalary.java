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
				request.setAttribute("id", "1");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/UpdateSalary.jsp");
				rd.forward(request, response);
			}
			else
			{
			
				response.sendRedirect("jsp/DisplayOption.jsp");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
	
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
				response.sendRedirect("jsp/DisplayOption.jsp");
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


