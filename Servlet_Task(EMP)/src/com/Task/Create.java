package com.Task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmz.anand.CreateUser;
import com.jmz.anand.User;
import com.jmz.jdbc.Jdbc_Insert_Class;

/**
 * Servlet implementation class Create
 */
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Create() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname=(String) Emp.hs.getAttribute("name");
		// String name1=Emp.ck.getValue();
		//String name1 = (String) Emp.sc.getAttribute("name");
		pw.println("<html>\r\n" + "\r\n" + "<title>jmz.com</title>\r\n" + "<style>" + "table label{" + "color:red" + "}"
				+ "</style>" + "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
				+ "</head>\r\n" + "<body><div class=\"main div\">\r\n"
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
				+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('bg1.jpg');\">\r\n"
				+ "<center><h2 style=color:red>" + uname + " " + "Please Enter below Details</h2>" + "<form>"
				+ "<table>" + "<tr><td><label >Enter Name</label></td><td><input type=text name=t1></td></tr>\r\n"
				+ "<tr><td><label >Enter age</label></td><td><input type=text name=t2></td></tr>\r\n"
				+ "<tr><td><input type=radio name=\"radio\" value=\"tester\">Tester<br>\r\n"
				+ "	<input type=radio name=\"radio\"value=\"programmer\">Programmer<br>\r\n"
				+ "	<input type=radio name=\"radio\"value=\"manager\">Manager</td>"
				+ "<td><input type=submit><br> <input type=reset></td></tr></table>"

				+ "</form>" + "<center></div>\r\n" + "<div class=\"footer_div\">\r\n"
				+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
				+ "</div>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");
		String name = request.getParameter("t1");
		String age = request.getParameter("t2");
		String Designation = request.getParameter("radio");
		int salary = 0;
		//int aSal[] = { 20000, 30000, 15000 };
		ServletConfig sc=getServletConfig();
		String tsalary=sc.getInitParameter("tsalary");
		String msalary=sc.getInitParameter("msalary");
		String psalary=sc.getInitParameter("psalary");
		if (Designation.equalsIgnoreCase("programmer")) {
			salary = Integer.parseInt(psalary);
		} else if (Designation.equalsIgnoreCase("manager")) {
			salary = Integer.parseInt(msalary);
		} else if (Designation.equalsIgnoreCase("tester")) {
			salary = Integer.parseInt(tsalary);
		}

		try {
			Jdbc_Insert_Class.insert(new User(name, age, Designation, salary));
		} catch (Exception e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
