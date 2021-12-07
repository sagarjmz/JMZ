package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBClass;
public class Validation extends HttpServlet {
	static Connection con;
	public void init() throws ServletException {
		}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher r1 = request.getRequestDispatcher("/DBClass");
			r1.include(request, response);
			con = DBClass.con;
			HttpSession session = request.getSession();
			session.setAttribute("a", request.getParameter("uname"));
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Statement st = con.createStatement();
			String nm = request.getParameter("uname");
			String pwd = request.getParameter("psw");
			ResultSet rs = st.executeQuery("SELECT * FROM newlogin where name = '" + nm + "' and pwd = '" + pwd + "'");

			if (rs.next()) {
				response.sendRedirect("jsp/Index.jsp");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('TRY AGAIN OR SIGN UP');");
				out.println("</script>");
				response.setContentType("text/html");
				out.println(" <<<<< INVALID DATA >>>>> ");
				out.println(
					"<html><head><center></head><body style=\"background-color: red\"><h1>SORRY USER</h1><h2>TRY AGAIN OR SIGN UP NOW</h2><p><b><a href='HTML/Login.html' ><input style = \"background-color: #28d; width:15%; height: 8%\" type=\"button\" value=\"LOG IN\"></a></b></p></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
