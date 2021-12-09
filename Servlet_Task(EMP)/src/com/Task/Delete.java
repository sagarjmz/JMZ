package com.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmz.anand.User;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter pw=response.getWriter();
//		pw.println("<html>\r\n"
//				+ "\r\n"
//				+ "<title>jmz.com</title>\r\n"
//				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
//				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
//				+ "</head>\r\n"
//				+ "<body><div class=\"main div\">\r\n"
//				+ "<div class=\"menu_div\" style=\"background-image:url('bg.jpg');\">\r\n"
//				+ "<h2><center><marquee>JMZ TECHNOLOGY</marquee></ceneter></h2>\r\n"
//				+ "<img src=\"jmz.png\" height=\"80\" width=\"100\">\r\n"
//				+ "\r\n"
//				+ "<a href=\"https://www.facebook.com/\" class=\"fb\">facebook</a>\r\n"
//				+ "<a class=\"twitter_tag\" href=\"https://twitter.com/i/flow/login\">twitter</a>\r\n"
//				+ "<a class=\"gmail\" href=\"https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin\">gmail</a>\r\n"
//				+ "<a class=\"linkdin\" href=\"https://www.linkedin.com/signup\">linkdin</a>\r\n"
//				+ "</div>\r\n"
//				+ "<div class=\"side_bar\" style=\"background-image:url('bg3.jpg');\">\r\n"
//				+ " <h3 class=\"menu\">MENU</h3><br>\r\n"
//				+ " <a href=\"Create\">CREATE</a><br><br>\r\n"
//				+ " <a href=\"Display\">DISPLAY</a><br><br>\r\n"
//				+ " <a href=\"RaiseSalary\">RAISE SALARY</a><br><br>\r\n"
//				+ " <a href=\"Delete\">DELETE</a>\r\n"
//				+ "</div>\r\n"
//				+ "<div class=\"center\" style=\"background-image:url('it4.jpg');\">\r\n"
//				+ "<center>"
//				+ "<form name=deleteform action=# method=get>"
//				+ "<h2 style=color:red>Enter Details To Delete Employee</h2>"
//				+ "<label style=color:red>Enter ID</label><input type=text name=t1><br><br>\r\n"
//				+ "<input type=submit>"
//				+ "</center>"
//				+ "</div>\r\n"
//				+ "<div class=\"footer_div\">\r\n"
//				+ "<footer style=\"background-image:url('bg.jpg');\"><h2><center>thankyou<center></h2></footer>\r\n"
//				+ "</div>\r\n"
//				+ "</div>\r\n");
		try {
				 String empid = request.getParameter("t1");
				Connection con;
				Statement st;
				String url = "jdbc:mysql://localhost:3306/emp1";
				String usr = "root";
				String pwd = "Year@2021";
				String sql = "delete from emp_table2 where emp_id='"+empid+"'";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, usr, pwd);
				st = con.createStatement();
				int r=st.executeUpdate(sql);
				if(r==1) {
					System.out.println("deleted");
				}else {
					System.out.println("error mention proper id");
				}
				String sql1 = "delete from emp_table1 where emp_id='"+empid+"'";
				int r1=st.executeUpdate(sql1);
				if(r1==1) {
					System.out.println("deleted");
				}else {
					System.out.println("error mention proper id");
				}
//				pw.println( "</body>\r\n"
//				+ "</html>");
		}catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd=request.getRequestDispatcher("JSP/Delete.jsp");
		rd.forward(request, response);
	}
	


}
