package com.restart;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Period extends HttpServlet {

	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/userdatabase";
	String uname = "root";
	String password = "Ailesh@22";

	public void init() throws ServletException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		String methodname = request.getMethod();
		if (methodname.equalsIgnoreCase("post")) {
			Statement ps = null;

			int r = 0;
			String name = request.getParameter("name");
			int password = Integer.parseInt(request.getParameter("password"));

			ResultSet rs;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				ps = con.createStatement();
				rs = ps.executeQuery(
						"select * from  user where username='" + name + "'and  userpassword =' "+ password +" '");
				if (rs.next()) {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<center>");
					pw.println("<font color=green>");
					pw.println("<h1>Valid User</h1>");
					pw.println("</center>");
					pw.println("</body>");
					pw.println("</html>");

				} else {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("<center>");
					pw.println("<font color=red>");
					pw.println("<h1>Invalid User</h1>");
					pw.println("</center>");
					pw.println("</body>");
					pw.println("<html>");
				}
			} catch (SQLException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			PreparedStatement ps = null;
			int r = 0;
			String url = "jdbc:mysql://localhost:3306/userdatabase";
			String uname = "root";
			String password = "Ailesh@22";
			String sql = "insert into user values(?,?)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, uname, password);
				ps = con.prepareStatement(sql);
				String username = request.getParameter("name");
				String userpassword = request.getParameter("psd");
				ps.setString(1, username);
				ps.setString(2, userpassword);
				r = ps.executeUpdate();
				if (r == 1) {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("</body>");
					pw.println("INSERTION DONE");
					pw.println("</html>");
				} else {
					pw.println("<html>");
					pw.println("<body>");
					pw.println("INSERTION NOT DONE");
					pw.println("</body>");
					pw.println("</html>");
				}
			} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
