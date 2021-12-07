package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBUtil;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static public List list;

    public Display() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");  
		ResultSet rs = null;
		//Connection con = null;
		try {
		//Class.forName("com.mysql.cj.jdbc.666666Driver");
		Statement st = con.createStatement();
		rs = st.executeQuery("SELECT * FROM new_table");
		
		 HttpSession session1=request.getSession();
		 String pname=(String) session1.getAttribute("name");
		pw.println("<!DOCTYPE html>\r\n" +
		"<html>\r\n" +
		"<head>\r\n" +
		"<style>\r\n" +
		"table {\r\n" +
		"  font-family: arial, green;\r\n" +
		"  border-collapse: collapse;\r\n" +
		"  width: 100%;\r\n" +
		"}\r\n" +
		"\r\n" +
		"td, th {\r\n" +
		"  border: 3px solid #9F1ABC;\r\n" +
		"  text-align: left;\r\n" +
		"  padding: 9px;\r\n" +
		"}\r\n" +
		"\r\n" +
		"tr:nth-child(even) {\r\n" +
		"  background-color: yellow;\r\n" +
		"}\r\n" +
		"</style>\r\n" +
		"</head>\r\n" +
		"<body bgcolor:teal color:grey><form action=\"Display\" method=\"post\">\r\n" +
		"\r\n" +
		"<h2>EMPLOYEES DETAILS DATA.....</h2>\r\n"
		+  "<h3>WELCOME "+pname+" " 
		+
		"\r\n" +
		"<table>\r\n" +
		"  <tr>\r\n" +
		"    <th>EMP_ID</th>\r\n" +
		"    <th>EMP_NAME</th>\r\n" +
		"    <th>EMP_AGE</th>\r\n" +
		"    <th>EMP_DESIGNATION</th>\r\n" +
		"    <th>EMP_SALARY</th>\r\n" +
		"  </tr>\r\n" +"");
		
		 
		            while (rs.next())
		            {  
		                String id = rs.getString("empid");  
		                String name = rs.getString("empname");
		                int age = rs.getInt("empage");
		                String deg = rs.getString("designation");
		                int sal = rs.getInt("empsalary");  
		                pw.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + deg + "</td><td>" + sal + "</td></tr>");  
		            }  
		            pw.println("</table>\r\n" +
		            "\r\n" +
		            "</body>\r\n" +
		            "</html>\r\n" +
		            "\r\n" +
		            "");
		           }  
		            catch (Exception e)
		           {  
		            e.printStackTrace();  
		        }  
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	