package com.jstl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeletePage() {
        super();
        }
    Connection con;
   	String url = "jdbc:mysql://localhost:3306/hpdata";
   	String uname = "root";
   	String pwd = "tiger";
   	
   	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//response.setContentType("text/html");
		//	PrintWriter pw = response.getWriter();
			
			PreparedStatement pst = con.prepareStatement("delete from student where emp_id = ?");
			String id = request.getParameter("id");
			pst.setString(1, id);
			int r = pst.executeUpdate();
			if (r == 1) {
				//pw.println("\n");
			//	pw.println(
				//		" <html><head><center></head><body style=\"color: #442A34; font-size:32px;;"
			//			+ " background-color:blue\">"
				//		+ "EMPLOYEE DATA DELETED</body></html> ");
				response.sendRedirect("JSP/FirstPage.jsp");

			} else {
				response.sendRedirect("JSP/Create.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();}}}
		
