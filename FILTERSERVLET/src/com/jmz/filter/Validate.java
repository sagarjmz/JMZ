package com.jmz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Validate implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get parameters from request object.
		String userName = request.getParameter("name");
		String password = request.getParameter("pwd");

		// check for null and empty values.
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username " + "and password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/login.html");
			requestDispatcher.include(request, response);
		} // Check for valid username and password.
		else if (userName.equals("uday") && password.equals("uday")) {
			chain.doFilter(request, response);
		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/login.html");
			requestDispatcher.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

}
