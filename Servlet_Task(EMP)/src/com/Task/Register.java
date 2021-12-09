package com.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta charset=\"ISO-8859-1\">\r\n"
			+ "<title>Insert title here</title>\r\n"
			+ "<style>\r\n"
			+ "body{\r\n"
			+ "background-image:url('bg2.jpg');\r\n"
			+ "background-repeat:no-repeat;\r\n"
			+ "background-size: cover;\r\n"
			+ "}\r\n"
			+ ".form_div{\r\n"
			+ "border: 1px solid white;\r\n"
			+ "height:250px;\r\n"
			+ "width:400px;\r\n"
			+ "display: flex;\r\n"
			+ "justify-content: center;\r\n"
			+ "margin-top: 15%;\r\n"
			+ "border-radius: 10px;\r\n"
			+ "background-image: url('bg.jpg');\r\n"
			+ "box-shadow: 5px 10px 18px red;\r\n"
			+ "}\r\n"
			+ "button a{\r\n"
			+ "text-decoration: none;\r\n"
			+ "}\r\n"
			+ "</style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "<center>\r\n"
			+ "<div class=\"form_div\">\r\n"
			+ "<form action=\"\" method=\"get\">\r\n"
			+ "<table style=text-align:left>\r\n"
			+ "<tr><td><th><h2 style=color:violet;>ENTER DETAILS</h4></th></td></tr>\r\n"
			+ "<tr>\r\n"
			+ "<td>UserName</td>\r\n"
			+ "<td><input type=\"text\" name=\"uname\"><br></td>\r\n"
			+ "</tr>\r\n"
			+ "<tr>\r\n"
			+ "<td>Password</td>\r\n"
			+ "<td><input type=\"text\" name=\"pwd\"><br></td>\r\n"
			+ "</tr><tr></tr>\r\n"
			+ "<tr><td><input type=\"submit\" value=\"submit\"></td>\r\n"
			+ "</table><br>\r\n"
			+ "</form>\r\n"
			+ "</div>\r\n"
			+ "</center>\r\n"
			+ "</body>\r\n"
			+ "</html>");
		Connection con = null;
		PreparedStatement pst = null;
		int r=0;
		String url = "jdbc:mysql://localhost:3306/emp1";
		String usr = "root";
		String pwd = "Year@2021";
		String sql = "insert into login_reg values(?,?)";
	
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, usr, pwd);
				pst = con.prepareStatement(sql);
				String name=request.getParameter("uname");
				String pass=request.getParameter("pwd");
				pst.setString(1, name);
				pst.setString(2, pass);
				r=pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	


}
