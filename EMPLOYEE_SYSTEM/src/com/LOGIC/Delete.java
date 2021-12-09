package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Delete extends HttpServlet {
	

	Connection con;
	String url = "jdbc:mysql://localhost:3306/employee3";
	String user = "root";
	String password = "Ailesh@22";

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();

			HttpSession session = request.getSession();

			session.setAttribute("dam", request.getParameter("user"));


			pw.println("Welcome User");
			System.out.println();
			pw.println(session.getAttribute("and"));
			

			pw.println("<html>\r\n" + "<html>\r\n" + "<head>\r\n" + "  <center>\r\n"
					
					+ "\r\n" 
					+ "<h2>DELETE</h2>\r\n" 
					+ "\r\n" 
					+ "<form action=\"delete\" method=\"\">\r\n" 
					+ "  \r\n"
					+ "\r\n" 
					+ "  <div class=\"container\">\r\n" 
					+ "    <label for=\"id\"><b>Id</b></label>\r\n"
					+ "    <input type=\"text\" placeholder=\"Enter Id\" name=\"id\" required>\r\n" 
					+ "\r\n"
					+ "    \r\n" + "    \r\n" + "\r\n" + "     \r\n" + "        \r\n"
					+ "    <button class=\"cancelbtn\" type=\"submit\">Delete</button>\r\n" 
					+ "    \r\n"
					+ "  </div>\r\n" + "\r\n" 
					+ "  <div class=\"container\" style=\"background-color:white\">\r\n"
					+ "    \r\n" + "  </div>\r\n" + "</form>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "");


			PreparedStatement pst = con.prepareStatement("delete from user2 where userid = ?");
			String id = request.getParameter("id");
			pst.setString(1, id);
			int r = pst.executeUpdate();
			if (r == 1) {
				pw.println("\n");
				pw.println(" <html><head><center></head><body style=\"color: black; font-size:32px;;"
						+ " background-color:grey\">" + "Data Removed</body></html> ");

			} else {

			}
			
			//RequestDispatcher rd1=request.getRequestDispatcher("Display");  
		   //    rd1.include(request, response);  

		} catch (Exception e) {
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