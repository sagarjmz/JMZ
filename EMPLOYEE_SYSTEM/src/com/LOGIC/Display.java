package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Display extends HttpServlet {
	
	static Connection con;
	String url = "jdbc:mysql://localhost:3306/employee3";
	String user = "root";
	String password = "Ailesh@22";

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		ResultSet rs = null;
		try {

			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user2");

			HttpSession session = request.getSession();

			session.setAttribute("bank", request.getParameter("uname"));
			
			pw.println("Welcome User");
			System.out.println();
			pw.println(session.getAttribute("a"));



			pw.println("<!DOCTYPE html>\r\n" 
			        + "<html>\r\n" 
					+ "<head>\r\n" 
			        + ""
			        + "<style>\r\n" 
					+ "table {\r\n"
					+ "  font-family: arial, lightgrey;\r\n" 
					+ "  border-collapse: collapse;\r\n" 
					+ "  width: 100%;\r\n"
					+ "}\r\n" 
					+ "\r\n" 
					+ "td, th {\r\n" 
					+ "  border: 3px solid white;\r\n" 
					+ "  text-align: left;\r\n"
					+ "  padding: 9px;\r\n" 
					+ "}\r\n" 
					+ "\r\n" 
					+ "tr:nth-child(even) {\r\n"
					+ "  background-color: white;\r\n" 
					+ "}\r\n" 
					+ "</style>\r\n" 
					+ "</head>\r\n"
					+ "<body bgcolor:red color:lightgrey><form action=\"displaypage\" method=\"post\">\r\n" 
					+ "\r\n"
					+ "<p style=\"color:lightgrey;\"><h2>Employee Info..</h2></p>\r\n" 
					+ "\r\n" 
					+ "<table>\r\n"
					+ "  <tr>\r\n" 
					+ "    <th>EMP_Id</th>\r\n"
					+ "    <th>EMP_Name</th>\r\n"
					+ "    <th>EMP_Age</th>\r\n" 
					+ "    <th>EMP_Department</th>\r\n" 
					+ "    <th>EMP_Salary</th>\r\n"
					+ "  </tr>\r\n" + "");
			while (rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("username");
				int age = rs.getInt("userage");
				String deg = rs.getString("userdept");
				int sal = rs.getInt("usersalary");
				pw.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + deg + "</td><td>"
						+ sal + "</td></tr>");
			}
			pw.println("</table>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "\r\n" + "");

			
//			RequestDispatcher rd=request.getRequestDispatcher("Delete");  
//		       rd.forward(request, response);
		       
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

