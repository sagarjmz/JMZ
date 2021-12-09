package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBUtil;

public class LogInValidate extends HttpServlet {
	    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		PreparedStatement pst;
		String name= request.getParameter("username");
		String pwd= request.getParameter("pass");
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery("SELECT username,password FROM login where username='"+name+"' and  password='"+pwd+"'");
			
			if(rs.next()) {
				response.sendRedirect("FirstServ");
				//pw.println("Valid User");
			}else {
				pw.println("Invalid User");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		PreparedStatement pst;
		String name= request.getParameter("username");
		String pwd= request.getParameter("pass");
		try {
			con = DBUtil.getConnection();
			pst=con.prepareStatement("insert into login values(?,?)");
			pst.setString(1, name);
			pst.setString(2, pwd);
			int ps=pst.executeUpdate();
			
			if (ps==1) {
				pw.println("Data insertion successfull....");
			}else {
				pw.println("Data insertion failed...");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}