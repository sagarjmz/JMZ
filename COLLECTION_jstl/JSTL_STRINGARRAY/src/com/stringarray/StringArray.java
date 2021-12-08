package com.stringarray;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StringArray extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StringArray() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value[]= {"SIKHA","SUHEL","AILESH","SATYA","ABHIK"};
		
		HttpSession ses=request.getSession();
		ses.setAttribute("stringArr", value);
		
		RequestDispatcher rd= request.getRequestDispatcher("JSP/NewFile.jsp");
		rd.forward(request, response);
	}

}
