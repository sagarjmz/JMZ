package com.uday;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmz.pojo.PersonId;
import com.jmz.util.*;

public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Connection con;

	
	public void init() throws ServletException {
		try {
			con = DBUtil.getSqlConnection();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PreparedStatement ps;
	ResultSet rs;
	String name=request.getParameter("name");
	String pass=request.getParameter("pwd");
	
	try {
		ps=con.prepareStatement("SELECT * from emp where uname=? and password=? ");
	
	ps.setString(1, name);
	ps.setString(2, pass);
	rs=ps.executeQuery();
	if(rs.next());
	String uname=rs.getString("uname");
	String password=rs.getString("password");
	String email=rs.getString("email");
	String phone =rs.getString("phone");
	PersonId person=new PersonId();
	person.setName(uname);
	System.out.println(person.getName());
	person.setEmail(email);
	System.out.println(person.getEmail());
	person.setPassword(password);
	System.out.println(person.getPassword());
	person.setPhonenumber(phone);
	System.out.println(person.getPhonenumber());
	request.setAttribute("pto", person);
	RequestDispatcher rd=request.getRequestDispatcher("jsp/first.jsp");
	rd.forward(request, response);
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
}
