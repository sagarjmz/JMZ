package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Create extends HttpServlet {

	Connection con;

	String url = "jdbc:mysql://localhost:3306/employee3";
	String user = "root";
	String password = "Ailesh@22";

	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head></head><body bgcolor=lightgrey align=center><div>"
				+ "<form action=\"create\" method=\"get\"><br><br>" 
				+ "<B><H2><U>CREATE  USER</U></H2><B><BR><H3><b>"
				+ "<label for=name <b>ENTER NAME:</b> </label> <input type=text name=\"username\" ><br><br>"
				+ "<label for=age <b>ENTER AGE:</b> </label> <input type=text name=\"userage\" ><br><br>"
				+ "<label for=dept <b>ENTER DEPT:</b> </label> "
				+ "<input type=text name=\"userdept\"><br> <br>" 
				+ "<input type=submit value=submit><b></H3><br><br>"
				+ "</div></form></body></html>");

		int min = 001;
		int max = 999;
		double empid2 = Math.random() * (max - min + 1) + min;
		int empid1 = (int) Math.round(empid2);
		String id = Integer.toString(empid1);

		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM");
		LocalDateTime now = LocalDateTime.now();
		String id1 = dateformat.format(now); // display current yyyy/month from system
		String[] id2arr = id1.split("/");
		id = id2arr[0] + "JMZ" + id2arr[1] + id;

		HttpSession session = request.getSession();
		pw.println("Welcome User");
		session.setAttribute("a", request.getParameter("username"));
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into user2 values(?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, request.getParameter("username"));
			pst.setInt(3, Integer.parseInt(request.getParameter("userage")));
			pst.setString(4, request.getParameter("userdept"));
			ServletConfig sc=getServletConfig();
		    /* <init-param>
		     <param-name>tsalary</param-name>
		     <param-value>15000</param-value>
		     </init-param>
		      <init-param>
		     <param-name>dsalary</param-name>
		     <param-value>20000</param-value>
		     </init-param>
		      <init-param>
		     <param-name>msalary</param-name>
		     <param-value>30000</param-value>
		     </init-param>*/
			//ServletContext sc=getServletContext();
            String desig=request.getParameter("userdept");
			int salary=0;
			String tsalary=sc.getInitParameter("tsalary");	
			String dsalary=sc.getInitParameter("dsalary");	
			String msalary=sc.getInitParameter("msalary");	
			if(desig.equalsIgnoreCase("tester")) {
				salary=Integer.parseInt(tsalary);
			}else if(desig.equalsIgnoreCase("developer")) {
				salary=Integer.parseInt(dsalary);
			}else
				salary=Integer.parseInt(msalary);
				
			
		
			pst.setInt(5, salary);
			int r = pst.executeUpdate();

			if (r == 1) {
				pw.println(" <html><head><center></head>"
						+ "<body style=\"color:black; font-size:30px; background-color:lightgrey\"> "
						+ "DATA INSERTED </body></html> ");
				
			}
			else {
				pw.println(" <html><head><center></head>"
						+ "<body style=\"color: grey; font-size:32px;; background-color: lightgrey\">"
						+ "INSERTION FAILED</body></html> ");	
			}
			RequestDispatcher rd1=request.getRequestDispatcher("Display");  
		    rd1.forward(request, response) ; 
			//RequestDispatcher rd1=request.getRequestDispatcher("Display");  
		     //rd1.include(request, response) ; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

