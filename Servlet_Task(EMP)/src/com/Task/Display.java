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

/**
 * Servlet implementation class Test
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Display() {
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
		Connection con;
		Statement st;
		String url = "jdbc:mysql://localhost:3306/emp1";
		String usr = "root";
		String pwd = "Year@2021";
		String name;
		String empid;
		int salary;
		String designation;
		String age;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);

			PreparedStatement pst = con.prepareStatement("select * from emp_table1");
			PreparedStatement pst1 = con.prepareStatement("select * from emp_table2 where emp_id=?");
			ResultSet rs = pst.executeQuery();
			pw.println("<html>\r\n" + "\r\n" + "<title>jmz.com</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
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
					+ "</div>\r\n" + "<div class=\"center\" style=\"background-image:url('it5.jpg');\">\r\n"
					+ "<center>");
			pw.println("<table border=1px solid black style=color:red><tr><th>Id</th><th>Name</th><th>Age</th><th>Designation</th><th>Salary</th>");
			while (rs.next()) {
				empid = rs.getString("emp_id");
				name = rs.getString("emp_name");
				age = rs.getString("emp_age");
				pst1.setString(1, empid);
				ResultSet rs1 = pst1.executeQuery();
				rs1.next();
				designation = rs1.getString(2);
				salary = rs1.getInt(3);
				pw.println("<tr><td>" + empid + "</td><td>" + name + "</td><td>" + age + "</td><td>" + designation
						+ "</td><td>" + salary + "</td></tr>");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		pw.println("</table></div>\r\n" + "<div class=\"footer_div\">\r\n"
				+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
				+ "</div>\r\n" + "</div>\r\n");
		pw.println("</body>\r\n" + "</html>");
	}

	
}
