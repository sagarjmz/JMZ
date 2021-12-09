package com.LOGIC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

public class RaiseSalary extends HttpServlet {

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


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();

			HttpSession session = request.getSession();

			session.setAttribute("come", request.getParameter("username"));

			pw.println("Welcome User");
			System.out.println();
			pw.println(session.getAttribute("and"));

			pw.println("<!DOCTYPE html>\r\n" 
			        + "</head>\r\n" 
					+ "<body style=\"background-color:lightgrey\">\r\n"
					+ "<center>\r\n" 
					+ "<h2>RAISE SALARY</h2>\r\n" 
					+ "\r\n" 
					+ "<form action=\"raisesalary\" method=\"get\">\r\n"
					+ "\r\n"  
					+ "<div style=\\\"background-color:lightgrey\\\" class=\"container\">\r\n"
					+"</br>"
					+ "<label for=\"id\"><b>userid</b></label>\r\n"
					+ "<input type=\"text\" placeholder=\"Enter Id\" name=\"userid\" required>\r\n" 
					+ "\r\n"
					+ "<label for=\"uname\"><b>username</b></label>\r\n"
					+ "<input type=\"text\" placeholder=\"Enter Name\" name=\"username\" required>\r\n" 
					+ "\r\n"
					+ "<button type=\"submit\">SUBMIT</button>\r\n" 
					+ "\r\n" 
					+ " </div>\r\n" 
					+ "\r\n"
					 
					+ "\r\n" 
					+ "</div>\r\n"
					+ "</form>\r\n" 
					+ "\r\n" 
					+ "</body>\r\n" 
					+ "</html>\r\n" 
					+ "");
			
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//}

	//protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//		throws ServletException, IOException {
	//	try {
	//		PrintWriter pw = response.getWriter();

		//	HttpSession session = request.getSession();
			Statement st = con.createStatement();
			PreparedStatement pst1 = con.prepareStatement("SELECT * FROM user2 WHERE userid = ?");
			ResultSet rs = st.executeQuery("SELECT * FROM user2");
			ResultSet rs1 = null;
			List<String> listId = new ArrayList<String>();
			while (rs.next()) {
				listId.add(rs.getString(1));
			}
			if (listId.contains(request.getParameter("id"))) {
				pst1.setString(1, request.getParameter("id"));
				rs1 = pst1.executeQuery();
				while (rs1.next()) {
					String nm = rs1.getString(2);
					int sal = rs1.getInt(5);
					if (request.getParameter("username").equalsIgnoreCase(nm)) {
						HttpSession s = request.getSession();
						s.setAttribute("id", request.getParameter("userid"));
						s.setAttribute("sal", sal);
						pw.println("\n");
						pw.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "  <center>\r\n"
						
//								+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
//								+ "<style>\r\n"
//								+ "body {font-family: Arial, Helvetica, sans-serif; width: 20%; margin-left: 25%;}\r\n"
//								+ "form {border: 4px solid #A41156;}\r\n" + "\r\n"
//								+ "input[type=text], input[type=password] {\r\n" + "  width: 25%;\r\n"
//								+ "  padding: 14px 20px;\r\n" + "  margin: 8px 0;\r\n" + "  display: inline-block;\r\n"
//								+ "  border: 1px solid #ccc;\r\n" + "  box-sizing: border-box;\r\n" + "}\r\n" + "\r\n"
//								+ "button {\r\n" + "  background-color: grey;\r\n" + "  color: grey;\r\n"
//								+ "  padding: 16px 22px;\r\n" + "  margin: 10px 0;\r\n" + "  border: none;\r\n"
//								+ "  cursor: pointer;\r\n" + "  width: 25%;\r\n" + "}\r\n" + "\r\n"
//								+ "button:hover {\r\n" + "  opacity: 0.8;\r\n" + "}\r\n" + "\r\n" + ".cancelbtn {\r\n"
//								+ "  width: auto;\r\n" + "  padding: 10px 18px;\r\n"
//								+ "  background-color: grey;\r\n" + "}\r\n" + "\r\n" + ".imgcontainer {\r\n"
//								+ "  text-align: center;\r\n" + "  margin: 24px 0 12px 0;\r\n" + "}\r\n" + "\r\n"
//								+ "img.avatar {\r\n" + "  width: 40%;\r\n" + "  border-radius: 50%;\r\n" + "}\r\n"
//								+ "\r\n" + ".container {\r\n" + "  padding: 16px;\r\n" + "}\r\n" + "\r\n"
//								+ "span.psw {\r\n" + "  float: right;\r\n" + "  padding-top: 16px;\r\n" + "}\r\n"
//								+ "\r\n" + "/* Change styles for span and cancel button on extra small screens */\r\n"
//								+ "@media screen and (max-width: 300px) {\r\n" + "  span.psw {\r\n"
//								+ "     display: block;\r\n" + "     float: none;\r\n" + "  }\r\n"
//								+ "  .cancelbtn {\r\n" + "     width: 16%;\r\n" + "  }\r\n" + "}\r\n" + "</style>\r\n"

								+ "</head>\r\n" 
								+ "<body bgcolor=lightgrey>\r\n" 
								+ "\r\n" + "\r\n" + "\r\n"
								+ "<form action=\"xyz\" method=\"post\">\r\n" 
								+ "  <div class=\"container\">\r\n"
								+ "    <label for=\"percentage\"><b>Percentage</b></label>\r\n"
								+ "    <input type=\"text\" placeholder=\"Enter Percentage to Raise Salary\" "
								+ "name=\"percentage\" required>\r\n" 
								+ "\r\n" + "    \r\n" + "    \r\n" + "\r\n"
								+ "     \r\n" 
								+ "        \r\n" 
								+ "    <button type=\"submit\">Submit</button>\r\n"
								+ "    \r\n" 
								+ "  </div>\r\n" 
								+ "\r\n"
								+ "  <div class=\"container\" style=\"background-color:lightgrey\">\r\n"
								+ "  </div>\r\n" 
								+ "</form>\r\n" 
								+ "\r\n" 
								+ "</body>\r\n" 
								+ "</html>\r\n" 
								+ "");
					} else {
						pw.println("\n");
						pw.println(" <html><head><center></head>"
								+ "<body style=\"color:grey; font-size:32px;; background-color:lightgrey\">"
								+ "Not Updated</body></html> ");
					}
				}
			}
			}	catch (Exception e) {
							e.printStackTrace();
						}
			
			}
		//	response.setContentType("text/html");
		//	PrintWriter pw2 = response.getWriter();

		//	HttpSession s = request.getSession();
		//	PreparedStatement pst = con.prepareStatement("update user2 set usersalary = ? where userid = ?");
				protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
					try {
						response.setContentType("text/html");
						HttpSession s = request.getSession();
						PreparedStatement pst = con.prepareStatement("update user2 set usersalary = ? where userid = ?");
						
			String id = (String) s.getAttribute("id");
			int sal = (Integer) s.getAttribute("sal");
			int p = Integer.parseInt(request.getParameter("percentage"));
			sal = sal + ((sal * p) / 100);
			pst.setInt(1, sal);
			pst.setString(2, id);
			int r = pst.executeUpdate();
			if (r == 1) {
				response.setContentType("text/html");
				PrintWriter pw1 = response.getWriter();

				pw1.println("\n");
				pw1.println(
						" <html><head><center></head><body style=\"background-color:lightgrey\" " + "<br><br><br><br><br>"
								+ "<h1>.......Data Updated........</h1><b>" + "</body></html> ");
			}
		} catch (Exception e) {

		}
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
