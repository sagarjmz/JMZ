package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBClass;
import com.TO.Employee;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//response.setContentType("text,html");
		//	PrintWriter out = response.getWriter();
			RequestDispatcher r1 = request.getRequestDispatcher("/DBClass");
			r1.include(request, response);
			Connection con = DBClass.con;
        String id = request.getParameter("id");
        Employee e = new Employee(id);
        //out.println(id);
       // out.println("hi");
        PreparedStatement pst = con.prepareStatement("delete from finalemp where empId = ?");
		pst.setString(1, e.getEmpId());
		int r = pst.executeUpdate();
		if (r == 1) {
			System.out.println("hi");
			/*pw.println("<script type=\"text/javascript\">");
			pw.println("alert('EMPLOYEE DATA DELETED');");
			pw.println("</script>");
			pw.println("\n");*/
			response.sendRedirect("jsp/Index.jsp");
		}else {
			//request.getRequestDispatcher("Delete").forward(request, response);
		}
        
      //  response.sendRedirect("EventDetails.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
