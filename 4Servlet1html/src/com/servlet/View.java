package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

public class View extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("pa", request.getParameter("pa"));
		session.setAttribute("ta", request.getParameter("ta"));
		session.setAttribute("married", request.getParameter("married"));
		session.setAttribute("phone", request.getParameter("phone"));
		
		doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		
			resp.getWriter().println("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<style>\n"
					+ "table, th, td {\n"
					+ "  border:0.5px solid black;\n"
					+"font-size:25px;\n"
					+ "}\n"
					
					+ "</style>\n"
					+ "<body>\n"
					+ "\n"
					+ "<h2>All Form Records</h2>\n"
					+ "\n"
					+ "<table style=\"width:100%\">\n"
					+ "  <tr>\n"
					+ "    <th>Description</th>\n"
					+ "\n"
					+ "   \n"
					+ "  </tr>");

			resp.getWriter().print("  <tr><td>"+session.getAttribute("uname")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("pwd")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("address")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("city")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("pin")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("street")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("did")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("dno")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("salary")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("designation")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("pa")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("ta")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("married")+"</td></tr>");
			resp.getWriter().print("  <tr><td>"+session.getAttribute("phone")+"</td></tr>");
			
			resp.getWriter().println("</table>\n"
					+ "\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
			
			
		
	}

}
