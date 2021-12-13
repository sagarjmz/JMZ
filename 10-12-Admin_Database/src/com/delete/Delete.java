package com.delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String candidate_id =request.getParameter("candidate_id");
		System.out.println(candidate_id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam","root","root");
			Statement stmt=con.createStatement();
			PreparedStatement pst=con.prepareStatement("DELETE FROM candidate_reg WHERE candidate_id=?");
			pst.setString(1, candidate_id);
			int ps= pst.executeUpdate();
			if(ps==1) {
				response.sendRedirect("jsp/passFail.jsp");
			}else {
				pw.print("failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
