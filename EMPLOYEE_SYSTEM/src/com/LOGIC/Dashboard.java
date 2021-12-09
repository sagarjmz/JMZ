package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dashboard extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action=./ab method='post'>");
		pw.println("<h1>");
		pw.println("<CENTER>");
		pw.println("<html>");
		pw.println("<head></head>");
	    pw.println ("<body style>");
		pw.println("<br>");
		pw.println("<div <h1 style=\"color: grey\">ENTER EMPLOY DETAILS : <h1>");
		pw.println("<h6><a href=\"Create\" style=\"margin-left: 5%\">1. CREATE EMPLOYEE</a></h6>");
		pw.println("<h6><a href=\"Display\" style=\"margin-left: 5%\">2. DISPLAY EMPLOYEES</a></h6>");
		pw.println("<h6><a href=\"RaiseSalary\" style=\"margin-left: 5%\">3. RAISE SALARY</a></h6>");
		pw.println ("<h6><a href=\"Delete\" style=\"margin-left: 5%\">4.DELETE EMPLOYEE</a></h6>");
		
		pw.println("</body>");
		pw.println ("</html>");
		
		 String name=request.getParameter("username");
	       String password=request.getParameter("password");
	       HttpSession session=request.getSession();
	       session.setAttribute("username", name);
	       session.setAttribute("password", password);

	}

}
