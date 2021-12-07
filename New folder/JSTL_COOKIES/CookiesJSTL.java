package com.jstlcookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesJSTL
 */
public class CookiesJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesJSTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String strfname=request.getParameter("fname");
		String strlname=request.getParameter("lname");
		
		Cookie c=new Cookie("fname",strfname);
		Cookie c1=new Cookie("lname",strlname);
		
		response.addCookie(c);
		response.addCookie(c1);
		
		pw.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<form action=\"jstl.jsp\">\r\n" + 
				"enter company name : <input type=\"text\" name=\"company\">\r\n" + 
				"enter salary  : <input type=\"text\" name=\"salary\">\r\n" + 
				"<input type=\"submit\" name=\"submit\">\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
