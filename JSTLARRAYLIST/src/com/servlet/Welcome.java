package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		PrintWriter pw=response.getWriter();
		ArrayList list=new ArrayList();
		list.add("uday");
		list.add("kumar");
		list.add("power");
		list.add("star");
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/first.jsp");
		rd.forward(request, response);
	}

}
