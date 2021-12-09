package com.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String name;
	static HttpSession hs;
	static Cookie ck;
	static ServletContext sc;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// response.setContentType("image/gif");
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/emp1";
		String usr = "root";
		String pwd = "Year@2021";
		String sql = "select * from login_reg where user_name='" + request.getParameter("uname") + "'and password='"
				+ request.getParameter("pwd") + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		PrintWriter pw = response.getWriter();

		pw.println("<html>\r\n" + "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
				+ "</head>\r\n" + "<body><div class=\"main div\">\r\n"
				+ "<div class=\"menu_div\" style=\"background-image:url('bg.jpg');\">\r\n"
				+ "<h2><center><marquee>JMZ TECHNOLOGY</marquee></ceneter></h2>\r\n"
				+ "<img src=\"jmz.png\" height=\"80\" width=\"100\">\r\n"
				+ "<a href=\"https://www.facebook.com/\" class=\"fb\">facebook</a>\r\n"
				+ "<a class=\"twitter_tag\" href=\"https://twitter.com/i/flow/login\">twitter</a>\r\n"
				+ "<a class=\"gmail\" href=\"https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin\">gmail</a>\r\n"
				+ "<a class=\"linkdin\" href=\"https://www.linkedin.com/signup\">linkdin</a>\r\n" + "</div>\r\n"
				+ "<div class=\"side_bar\" style=\"background-image:url('bg3.jpg');\">\r\n"
				+ " <h3 class=\"menu\">MENU</h3><br>\r\n" + " <a href=\"Create\">CREATE</a><br><br>\r\n"
				+ " <a href=\"Display\">DISPLAY</a><br><br>\r\n"
				+ " <a href=\"RaiseSalary\">RAISE SALARY</a><br><br>\r\n" + " <a href=\"Delete\">DELETE</a>\r\n"
				+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('it1.jpg');\">\r\n"
				+ "<h2 style=color:red>Welcome "+name+"</h2></div>\r\n" + "<div class=\"footer_div\">\r\n"
				+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
				+ "</div>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");

//				 else {
//					pw.println("<html>" + "<head>" + "<style>" + "body{" + "background-image:url(wrong.png);" + "}"
//							+ "</style>" + "</head>" + "<body>" + "<h2 style=color:red>Wrong ID or Password</h2>"
//							+ "</body>" + "</html>");
//				}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		hs=request.getSession();
		
		name = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		hs.setAttribute("name", name);
//		ck=new Cookie("name",name);
//		ck.setValue(name);
		//sc=request.getServletContext();
//		sc.setAttribute("name", name);
		ServletContext sc=getServletContext();
		String name1=sc.getInitParameter("name");
		String pwd=sc.getInitParameter("pwd");
		if(name1.equalsIgnoreCase(name)&&pwd.equals(pass)) {
			response.sendRedirect("an");
		}else {
			response.sendRedirect("HTML/Login.html");
		}
//		try {
//			if (Validate.validate(name, pass)) {
//				System.out.println("emp");
//				response.sendRedirect("an");
//
//			} else {
//				System.out.print("wrong id or password");
//				response.sendRedirect("HTML/Login.html");
//
//			}
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
