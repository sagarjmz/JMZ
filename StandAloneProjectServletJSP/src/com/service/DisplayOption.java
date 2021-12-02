package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisplayOption extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.getAttribute("loginId");
		DisplayUser.listClear();
		PrintWriter pw = response.getWriter();
		Cookie[] cookie = request.getCookies();
		String Lid = null; 
		for(Cookie c : cookie)
		{
			// Lid = c.getValue();
			System.out.println(c.getName());
		
		}
	Lid = cookie[1].getValue();
			pw.print("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<style>\n"
					+ "a:link, a:visited {\n"
					+ "  background-color: white;\n"
					+ "  color: black;\n"
					+ "  border: 2px solid green;\n"
					+ "  padding: 10px 20px;\n"
					+ "  text-align: center;\n"
					+ "  text-decoration: none;\n"
					+ "  display: inline-block;\n"
					+"margin-left:45%;"
					+ "}\n"
					+ "\n"
					+ "a:hover, a:active {\n"
					+ "  background-color: green;\n"
					+ "  color: white;\n"
					+ "}\n"
					+ "</style>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "\n"
					+"<h1 >"+"Welcome : "+Lid+"</h1>"
					+ "<h2 style=\"text-align:center\">Employee Management System </h2>\n"
					+ "\n"
					+ "<a href=\"CreateUser\" >Create User &nbsp;</a><br><br>\n"
					+ "<a href=\"jsp/DisplayUser.jsp\" >Display User </a><br><br>\n"
					+ "<a href=\"RaiseSalary\" >Raise Salary </a><br><br>\n"
					+ "<a href=\"Delete\" >Delete User </a><br><br>\n"
					+ "<a href=\"html/login.html\" > &nbsp; &nbsp; &nbsp; &nbsp; Exit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a><br><br>\n"
					+ "\n"
					+ "</body>\n"
					+ "</html>");
	
		
	}



}
