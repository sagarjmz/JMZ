package com.login;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.DB.DBUtil;
import com.pojo.Pojo;

/**
 * Servlet implementation class Creatuser
 */
public class CreatUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int salary;
	public CreatUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		try {
			con=DBUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// String name=request.getParameter("uname");
//		 String age=request.getParameter("age");
//		 String designation=request.getParameter("desig");
		 HttpSession session=request.getSession();
		// session.setAttribute("name", name);
		// session.setAttribute("age", age);
		 //session.setAttribute("desig", designation);
		 String uname=(String) session.getAttribute("name");
		// String uage=request.getParameter("age");
		// String udesig=request.getParameter("desig");
		// pw.println(session.getAttribute("name"));
		pw.println("<html><head></head><body bgcolor=teal align=center><div>"
				+ "<form action=\"Creatuser\" method=\"get\"><br><br>"
				+ "<h3>WELCOME "+uname+" "
				+ "<B><H2><U>CREATE  USER</U></H2><B><BR><H3><br<br>\r\n"
				+ "<label for=name <b>ENTER NAME:</b> </label> <input type=text name=\"uname\" ><br><br>"
				+ "<label for=age <b>ENTER AGE:</b> </label> <input type=text name=\"age\" ><br><br>"
				+ "<label for=designation <b>ENTER DESIGNATION:</b> </label> "
				+ "<input type=text name=\"desig\"><br> <br>"
				+ "<input type=submit value=submit><b></H3><br><br>"
				
				
				+ "</div></form></body></html>");
		


		String desig=request.getParameter("desig");
		if(desig.equalsIgnoreCase("Programmer")) {
			salary=20000;
		}else if(desig.equalsIgnoreCase("Tester")) {
			salary=15000;
		}else if(desig.equalsIgnoreCase("Manager")) {
			salary=30000;
		}
		int min = 001;
		int max = 999;
		double empid2 = Math.random() * (max - min + 1) + min;
		int empid1 = (int) Math.round(empid2);
		String id = Integer.toString(empid1);
		// String id1 = String.valueOf(id);
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM");
		LocalDateTime now = LocalDateTime.now();
		String id1 = dateformat.format(now); // display current yyyy/month from system
		String[] id2arr = id1.split("/");
		id = id2arr[0] + "JMZ" + id2arr[1] + id;
		//Connection con;
		PreparedStatement pst;
		
		Pojo p=new Pojo(id, request.getParameter("uname"),Integer.parseInt(request.getParameter("age")), request.getParameter("desig"),salary);
		
		try {
			pst = con.prepareStatement("insert into new_table values(?,?,?,?,?)");
			pst.setString(1, p.getEmpid());
			pst.setString(2, p.getEmpname());
			pst.setInt(3, p.getEmpage());
			pst.setString(4, p.getDesignation());
			//String Websalary=sc.getInitParameter("salary");
			
		//	int salary = Integer.parseInt(Websalary);
			pst.setInt(5, p.getEmpsalary());
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = st.executeQuery("select * from new_table");
			rs1.last();
			if (rs1.getRow() >= 10) {
				rs1.first();
				rs1.deleteRow();

				int r = pst.executeUpdate();
				if (r == 1) {
					response.sendRedirect("JSP/Main.jsp");
				} else {
					pw.println(
							" <html><head><center></head><body style=\"color: red; font-size:32px;; background-color: sky\"><<<<< INSERTION FAILED >>>>></body></html> ");
				}

			} else {
				int r = pst.executeUpdate();
				if (r == 1) {
					response.sendRedirect("JSP/Main.jsp");
				} else {
					pw.println(
							" <html><head><center></head><body style=\"color: red; font-size:32px;; background-color: sky\"><<<<< INSERTION FAILED >>>>></body></html> ");
				}
			}
			//RequestDispatcher rd=request.getRequestDispatcher("Display");
			//rd.forward(request, response);
			/*
			 * RequestDispatcher rd=request.getRequestDispatcher("Delete");
			 * rd.include(request, response);
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() {
try {
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
