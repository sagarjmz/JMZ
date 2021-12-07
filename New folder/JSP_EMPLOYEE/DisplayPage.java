package com.jshx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DisplayPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    static Connection con;
	String url = "jdbc:mysql://localhost:3306/hpdata";
	String uname = "root";
	String pwd = "tiger";
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		ResultSet rs = null;
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM student");
			response.setContentType("text/html");
			while (rs.next()) {
				String id = rs.getString("emp_id");
				String name = rs.getString("emp_name");
				int age = rs.getInt("emp_age");
				String deg = rs.getString("emp_designation");
				int sal = rs.getInt("emp_salary");
				pw.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + deg + "</td><td>"
						+ sal + "</td></tr>");
			}
			pw.println("</table>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "\r\n" + "");

		} catch (Exception e) {
			e.printStackTrace();
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
