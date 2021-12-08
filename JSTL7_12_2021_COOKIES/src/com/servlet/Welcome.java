package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		Cookie FNAMEs=new Cookie("fname", fname);
		Cookie LNAMEs=new Cookie("lname", lname);
		response.addCookie(FNAMEs);
		response.addCookie(LNAMEs);
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action=jsp/withEL.jsp>");
		pw.println("<h1>");
		pw.println("CompanyName:<input type=text name=compname>");
		pw.println("Salary:<input type=text name=sal>");
		pw.println("Submit: <input type=submit value=submit>");
		pw.println("</form>");
		pw.println("</h1>");
		pw.println("</body>");
		pw.println("</html>");
	}

	

}
