package com.demo;

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

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Connection con=null;
		PreparedStatement ps=null;
		int r=0;
		String url="jdbc:mysql://localhost:3306/register";
		String usr="root";
		String pwd="root";
		String sql="insert into register values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usr,pwd);
			ps=con.prepareStatement(sql);
			String name=request.getParameter("name");
			String pass=request.getParameter("psd");
			ps.setString(1, name);
			ps.setString(2, pass);
			r=ps.executeUpdate();
			if(r==1) {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("</body>");
				pw.println("INSERTION SUCCESS");
				pw.println("</html>");
			}
			else {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("Insertion unsuccess");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement ps=null;
	
	
		int r=0;
		String url="jdbc:mysql://localhost:3306/register";
		String usr="root";
		String pwd="root";
		String name=request.getParameter("name");
		String psd=request.getParameter("psd");
		PrintWriter pw=response.getWriter();
		ResultSet rs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usr,pwd);
			ps = con.createStatement();
			rs = ps.executeQuery("select * from  register where name='"+name+"' and password='"+psd+"'");
			if(rs.next()) {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<center>");
				pw.println("<font color=lightgreen>");
				pw.println("<h1>Hello Welcome To JMZ World</h1>");
				pw.println("</center>");
				pw.println("</body>");
				pw.println("</html>");
				
			}
			else {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<center>");
				pw.println("<font color=red>");
				pw.println("<h1>Getout From JMZ World</h1>");
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
		
			
		}
	}


