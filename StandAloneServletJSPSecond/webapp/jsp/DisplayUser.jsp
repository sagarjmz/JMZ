
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.entity.java.User"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.jdbc.java.Connections"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%!  Connection con = Connections.con;
	 PreparedStatement pst;
	 PreparedStatement pst1;
	 Statement st;
	 Statement st1;
	 List<User> list = new LinkedList<User>();
	%>
	<% st = con.createStatement();
	st1 = con.createStatement();
	ResultSet rs = st.executeQuery("select * from Core.userData");

	while (rs.next()) {

		ResultSet rs1 = st1
				.executeQuery("select * from Core.designation where userId ='" + rs.getString(1) + "'");
		rs1.next();

		list.add(new User(rs.getString("userName"), rs1.getString("Designation"), rs1.getLong("Salary"),
				rs.getString("userId"), rs.getInt("userAge")));

	} %>
	<!DOCTYPE html> <html> <head> <style> #customers {
					  font-family: Arial, Helvetica, sans-serif;   border-collapse: collapse;
					  width: 100%; }  #customers td, #customers th {
					  border: 1px solid #ddd;   padding: 8px; } 
					#customers tr:nth-child(even){background-color: #f2f2f2;} 
					#customers tr:hover {background-color: #ddd;}  #customers th {
					  padding-top: 12px;   padding-bottom: 12px;   text-align: left;
					  background-color: #04AA6D;   color: white; } </style> </head>
					<body>  <h1>User Record Table</h1>  <table id="customers">
					  <tr>      <th>SN</th>  <th>Id</th>     <th>Name</th>     <th>Age</th>
					    <th>Designation</th>         <th>Salary</th> <th>Edit</th> <th>Delete</th>   </tr>   
					    
					    <%	Iterator i = list.iterator();
					    int sn = 1;
						while (i.hasNext()) {
							User user = (User) i.next();
							out.print("  <tr> <td>"+sn+++"</td>\n" + "    <td>" + user.getUid() + "</td>\n" + "    <td>" + user.getName() + "</td>\n"
									+ "    <td>" + user.getAge() + "</td>\n" + "     <td>" + user.getDesignation() + "</td>\n"
									+ "    <td>" + user.getSalary() + "</td>\n" + "<td><a href=UpdateSalary.jsp?id="+user.getUid()+"&salary="+user.getSalary()+">edit</a></td><td><a href=../Delete?id="+user.getUid()+">delete</a></td>  </tr>\n");
						} %>
					    <% list.clear(); %>
					    </table></body></html>