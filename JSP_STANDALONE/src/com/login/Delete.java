package com.login;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBUtil;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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

    try {
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
	/*
	 * String name=request.getParameter("uname"); String
	 * age=request.getParameter("age"); String
	 * designation=request.getParameter("desig"); HttpSession
	 * session=request.getSession(); session.setAttribute("uname", name);
	 * session.setAttribute("age", age); session.setAttribute("desig", designation);
	 * String pname=(String) session.getAttribute("uname");
	 */
	/*
	 * HttpSession session=request.getSession(); String uname=(String)
	 * session.getAttribute("name");
	 */ 	 
    pw.println("<html>\r\n" + "<html>\r\n"
    + "<head>\r\n" + "  <center>\r\n"
    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=2\">\r\n"
    + "<style>\r\n"
    + "body bgcolor:teal {font-family:purple, Helvetica, sans-serif; width: 50%; margin-left: 25%;}\r\n"
    + "<form action=\"delete\" method=\"post\" {border: 6px solid #9F1ABC;}\r\n"
    + "\r\n"
    + "input[type=text], input[type=password] {\r\n"
    + "  width: 50%;\r\n"
    + "  padding: 14px 22px;\r\n"
    + "  margin: 9px 0;\r\n"
    + "  display: inline-block;\r\n"
    + "  border: 3px solid #cdc;\r\n"
    + "  box-sizing: border-box;\r\n"
    + "}\r\n" + "\r\n" + "button {\r\n"
    + "  background-color: teal;\r\n" + "  color: teal;\r\n"
    + "  padding: 15px 22px;\r\n" + "  margin: 9px 0;\r\n"
    + "  border: none;\r\n"
    + "  cursor: pointer;\r\n"
    + "  width: 50%;\r\n" + "}\r\n" + "\r\n"
    + "button:hover {\r\n"
    + "  opacity: 0.8;\r\n" + "}\r\n" + "\r\n" + ".cancelbtn {\r\n"
    + "  width: auto;\r\n"
    + "  padding: 10px 18px;\r\n" + "  background-color: green;\r\n"
    + "}\r\n" + "\r\n"
    + ".imgcontainer {\r\n" + "  text-align: center;\r\n"
    + "  margin: 24px 0 12px 0;\r\n" + "}\r\n"
    + "\r\n" + "img.avatar {\r\n" + "  width: 40%;\r\n"
    + "  border-radius: 60%;\r\n" + "}\r\n" + "\r\n"
    + ".container {\r\n" + "  padding: 17px;\r\n" + "}\r\n"
    + "\r\n" + "span.psw {\r\n"
    + "  float: right;\r\n" + "  padding-top: 18px;\r\n"
    + "}\r\n" + "\r\n"
    + "/* Change styles for span and cancel button on extra small screens */\r\n"
    + "@media screen and (max-width: 320px) {\r\n" + "  span.psw {\r\n" + "     display: block;\r\n"
    + "     float: none;\r\n" + "  }\r\n" + "  .cancelbtn {\r\n" + "     width: 10%;\r\n" + "  }\r\n"
    + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body style=\"background-color:teal\">\r\n" + "\r\n" + "<h2>DELETE</h2>\r\n"
   // + "<h3>WELCOME "+uname+" "
    + "<form action=\"delete\" method=\"\">\r\n" + "  \r\n" + "\r\n" + "  <div class=\"container\">\r\n"
   
    + "    <label for=\"id\"><b>Id</b></label>\r\n"
    + "    <input type=\"text\" placeholder=\"Enter Id\" name=\"id\" required>\r\n" + "\r\n"
    + "    \r\n" + "    \r\n" + "\r\n" + "     \r\n" + "        \r\n"
    + "    <button class=\"cancelbtn\" type=\"submit\">Delete</button>\r\n"
    + "    <button class=\"cancelbtn\" type=\"Back\">Back</button>\r\n" + "    \r\n"
    + "  </div>\r\n" + "\r\n" + "  <div class=\"container\" style=\"background-color:teal\">\r\n"
    +  "    \r\n"
    + "  </div>\r\n" + "</form>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "");
 

   // Statement st = con.createStatement();
   PreparedStatement pst = con.prepareStatement("delete from new_table where empid = ?");
    String id = request.getParameter("id");
    pst.setString(1, id);
    int r = pst.executeUpdate();
    if (r == 1) {
//    pw.println("\n");
//    pw.println(
//    " <html><head><center></head><body style=\"color: teal; font-size:32px;;"
//    + " background-color:red\">"
//    + "EMPLOYEE DATA DELETED</body></html> ");
    	response.sendRedirect("JSP/Main.jsp");
    } else {
    	pw.println("not deleted");
    }

    } catch (Exception e) {
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
