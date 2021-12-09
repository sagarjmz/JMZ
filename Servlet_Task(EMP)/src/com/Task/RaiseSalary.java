package com.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Create
 */
public class RaiseSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>\r\n" + "\r\n" + "<title>jmz.com</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
				+ "</head>\r\n" + "<body><form action=\"ai\" method=\"post\"<div class=\"main div\">\r\n"
				+ "<div class=\"menu_div\" style=\"background-image:url('bg.jpg');\">\r\n"
				+ "<h2><center><marquee>JMZ TECHNOLOGY</marquee></ceneter></h2>\r\n"
				+ "<img src=\"jmz.png\" height=\"80\" width=\"100\">\r\n" + "\r\n"
				+ "<a href=\"https://www.facebook.com/\" class=\"fb\">facebook</a>\r\n"
				+ "<a class=\"twitter_tag\" href=\"https://twitter.com/i/flow/login\">twitter</a>\r\n"
				+ "<a class=\"gmail\" href=\"https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin\">gmail</a>\r\n"
				+ "<a class=\"linkdin\" href=\"https://www.linkedin.com/signup\">linkdin</a>\r\n" + "</div>\r\n"
				+ "<div class=\"side_bar\" style=\"background-image:url('bg3.jpg');\">\r\n"
				+ " <h3 class=\"menu\">MENU</h3><br>\r\n" + " <a href=\"Create\">CREATE</a><br><br>\r\n"
				+ " <a href=\"Display\">DISPLAY</a><br><br>\r\n"
				+ " <a href=\"RaiseSalary\">RAISE SALARY</a><br><br>\r\n" + " <a href=\"Delete\">DELETE</a>\r\n"
				+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('it3.jpg');\">\r\n" + "<center>"
				+ "<h2>Enter Details To Raise Employee Salary</h2>" + "<table>"
				+ "<tr><td><label color>Enter ID</label></td><td><input type=text name=t1></td></tr>\r\n"
				+ "<tr><td><label color>Enter Name</label></td><td><input type=text name=t2></td></tr>\r\n"
				+ "<tr><td><input type=submit></td></tr></table>" + "</center>" + "</form></div>\r\n"
				+ "<div class=\"footer_div\">\r\n"
				+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
				+ "</div>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw1 = response.getWriter();
		String x=request.getParameter("t1");
		//System.out.println(x);
//		pw1.println(request.getParameter("t1"));
		Connection con;
		Statement st;
		String url = "jdbc:mysql://localhost:3306/emp1";
		String usr = "root";
		String pwd = "Year@2021";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);

			String id = request.getParameter("t1");
			//pw1.println(id);
			
			String name = request.getParameter("t2");
			st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from emp_table1 where emp_id='" + id + "'");
			
			while (rs.next()) {
				String name1 = rs.getString(2);
				if (name.equals(name1)) {
					HttpSession hs=request.getSession();
					
					hs.setAttribute("id", request.getParameter("t1"));
					pw1.println("<html>\r\n"
							+  "<title>jmz.com</title>\r\n"
							+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
							+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
							+ "</head>\r\n" + "<body><form action=\"abcd\" method=\"post\"<div class=\"main div\">\r\n"
							+ "<div class=\"menu_div\" style=\"background-image:url('bg.jpg');\">\r\n"
							+ "<h2><center><marquee>JMZ TECHNOLOGY</marquee></ceneter></h2>\r\n"
							+ "<img src=\"jmz.png\" height=\"80\" width=\"100\">\r\n" + "\r\n"
							+ "<a href=\"https://www.facebook.com/\" class=\"fb\">facebook</a>\r\n"
							+ "<a class=\"twitter_tag\" href=\"https://twitter.com/i/flow/login\">twitter</a>\r\n"
							+ "<a class=\"gmail\" href=\"https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin\">gmail</a>\r\n"
							+ "<a class=\"linkdin\" href=\"https://www.linkedin.com/signup\">linkdin</a>\r\n" + "</div>\r\n"
							+ "<div class=\"side_bar\" style=\"background-image:url('bg3.jpg');\">\r\n"
							+ " <h3 class=\"menu\">MENU</h3><br>\r\n" + " <a href=\"Create\">CREATE</a><br><br>\r\n"
							+ " <a href=\"Display\">DISPLAY</a><br><br>\r\n"
							+ " <a href=\"RaiseSalary\">RAISE SALARY</a><br><br>\r\n" + " <a href=\"Delete\">DELETE</a>\r\n"
							+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('it3.jpg');\">\r\n" + "<center>"
							+ "<h2>Enter percentage To Raise Employee Salary</h2>" + "<table>"
							+ "<tr><td><label>Enter percentage</label></td><td><input type=text name=t3></td></tr>\r\n"
							+ "<tr><td><input type=submit></td></tr>"
							+ "<tr><td><input type=hidden name=t4 value='"+x+"'></td></tr></table>" + "</center>" + "</form></div>\r\n"
							+ "<div class=\"footer_div\">\r\n"
							+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
							+ "</div>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");
					} else {
					pw1.println("<html>\r\n"
							+  "<title>jmz.com</title>\r\n"
							+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
							+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
							+ "</head>\r\n" + "<body><form action=\"abcd\" method=\"post\"<div class=\"main div\">\r\n"
							+ "<div class=\"menu_div\" style=\"background-image:url('bg.jpg');\">\r\n"
							+ "<h2><center><marquee>JMZ TECHNOLOGY</marquee></ceneter></h2>\r\n"
							+ "<img src=\"jmz.png\" height=\"80\" width=\"100\">\r\n" + "\r\n"
							+ "<a href=\"https://www.facebook.com/\" class=\"fb\">facebook</a>\r\n"
							+ "<a class=\"twitter_tag\" href=\"https://twitter.com/i/flow/login\">twitter</a>\r\n"
							+ "<a class=\"gmail\" href=\"https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin\">gmail</a>\r\n"
							+ "<a class=\"linkdin\" href=\"https://www.linkedin.com/signup\">linkdin</a>\r\n" + "</div>\r\n"
							+ "<div class=\"side_bar\" style=\"background-image:url('bg3.jpg');\">\r\n"
							+ " <h3 class=\"menu\">MENU</h3><br>\r\n" + " <a href=\"Create\">CREATE</a><br><br>\r\n"
							+ " <a href=\"Display\">DISPLAY</a><br><br>\r\n"
							+ " <a href=\"RaiseSalary\">RAISE SALARY</a><br><br>\r\n" + " <a href=\"Delete\">DELETE</a>\r\n"
							+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('it3.jpg');\">\r\n" + "<center>"
							+ "<h2 style=color:red>wrong ID or NAme</h2>"
							+ "<h3 style=color:red>Please enter respective ID and NAME</h3>"
							+ "</center>" + "</form></div>\r\n"
							+ "<div class=\"footer_div\">\r\n"
							+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
							+ "</div>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");
				}
			}
		HttpSession hs1=request.getSession();
			String id1 = (String) hs1.getAttribute("id");
//			String id1 = (String) request.getAttribute("t4");
			System.out.println(id1);
			//pw1.println(id1);
			st = con.createStatement();
			ResultSet rs1=st.executeQuery("select * from emp_table2 where emp_id='" + id1 + "'");
			while(rs1.next()) {
			int salary=rs1.getInt(3);
			int percentage = Integer.valueOf(request.getParameter("t3"));
			salary=salary+(salary*percentage)/100;
			
			PreparedStatement pst = con.prepareStatement("update emp_table2 set salary =? where emp_id=?");
			pst.setInt(1, salary);
			pst.setString(2, id1);
			int b=pst.executeUpdate();
			if(b==1) {
				response.sendRedirect("RaiseSalary");
			}else {
				System.out.println("not");
			}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
