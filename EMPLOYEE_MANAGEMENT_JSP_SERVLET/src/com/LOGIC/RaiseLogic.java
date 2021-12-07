package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBClass;
import com.TO.Employee;

public class RaiseLogic extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text,html");
		PrintWriter pw = response.getWriter();
		//String id = request.getParameter("id");
		//int sal1 = Integer.parseInt(request.getParameter("sal"));
		int p = Integer.parseInt(request.getParameter("percentage"));
		
		
		Employee e = new Employee(request.getParameter("id"), Integer.parseInt(request.getParameter("sal")));
		int sal = e.getSalary() + ((e.getSalary() * p) / 100);
		request.getRequestDispatcher("/DBClass").include(request, response);
		Connection con = DBClass.con;
		Statement st = con.createStatement();
		PreparedStatement pst = con.prepareStatement("update finalemp set salary = ? where empId = ?");
		pst.setInt(1, sal);
		pst.setString(2, e.getEmpId());
		int rs = pst.executeUpdate();
		while (rs==1) {
			/*
			 * pw.println("<script type=\"text/javascript\">");
			 * pw.println("alert('SALARY RAISED SUCCESSFULLY');"); pw.println("</script>");
			 */
			response.sendRedirect("jsp/Display.jsp");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
