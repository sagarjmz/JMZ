package com.jstl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RaiseSalaryPage
 */
public class RaiseSalaryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RaiseSalaryPage() {
        super();
        }
    Connection con;
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
		
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String id=request.getParameter("id");
			
			int sal1=Integer.parseInt(request.getParameter("sal"));
			int p=Integer.parseInt(request.getParameter("percentage"));
			int sal=sal1+((sal1*p)/100);
			
		
		Statement st = con.createStatement();
		PreparedStatement pst = con.prepareStatement("update student set emp_salary=? WHERE emp_id = ?");
		//ResultSet rs = st.executeQuery("SELECT * FROM student");
		pst.setInt(1,sal);
		pst.setString(2,id);
		int rs=pst.executeUpdate();		
		while(rs==1)
		{
			
			response.sendRedirect("JSP/Display.jsp");
		}
		/*
		 * ResultSet rs1 = null; List<String> listId = new ArrayList<String>(); while
		 * (rs.next()) { listId.add(rs.getString(1)); } if
		 * (listId.contains(request.getParameter("id"))) { pst1.setString(1,
		 * request.getParameter("id")); rs1 = pst1.executeQuery(); while (rs1.next()) {
		 * String nm = rs1.getString(2); int sal = rs1.getInt(5); } }
		 */
		
		
		}
				
				 catch (Exception e) {
						e.printStackTrace();
					}
	
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
