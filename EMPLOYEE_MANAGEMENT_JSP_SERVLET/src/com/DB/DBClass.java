package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBClass extends HttpServlet {
	public static Connection con;
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter("driver");
		String path = config.getInitParameter("path");
		String user = config.getInitParameter("user");
		String pwd = config.getInitParameter("pwd");
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(path, user, pwd);
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}
	}

}
