<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


 <style>  
 table {
					   font-family: arial, purple;    border-collapse: collapse;    width: 100%;
					 }    td, th {    border: 3px solid #9F1ABC;    text-align: left;
					   padding: 9px;  }    tr:nth-child(even) {
					   background-color: #9F1ABC;  }  
					   </style>  
					   </head>
					 <body bgcolor:red color:red>
					 <% int i=1;
					 try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hpdata", "root", "tiger");
	ResultSet rs = null;
	Statement st = con.createStatement();%>
	
					 <form action="../DisplayPage" method="">  
					 <p style=\color:red;\><h2>EMPLOYEES DETAILS DATA.....</h2></p>    <table>
					   <tr>    <th>SN</th>  <th>EMP_ID</th>      <th>EMP_NAME</th>
					     <th>EMP_AGE</th>      <th>EMP_DESIGNATION</th>      <th>EMP_SALARY</th> <th>EDIT</th><TH>DELETE</TH>
					   </tr> 
					   <% rs = st.executeQuery("SELECT * FROM student");
	while (rs.next()) {
		String id = rs.getString("emp_id");
		String name = rs.getString("emp_name");
		int age = rs.getInt("emp_age");
		String deg = rs.getString("emp_designation");
		int sal = rs.getInt("emp_salary");
	%> 
					   <tr>
					   <td><%= i++ %></td>
					   <td><%=id %></td>
					   <td><%=name %></td>
					   <td><%=age %></td>
					   <td><%=deg%></td>
					   <td><%=sal %></td>
					   	<td><a href='RaiseSalary.jsp?id=<%=rs.getString(1) %>&&sal=<%=rs.getString(5)%>'>RAISE_SAL</a></td>
					    <td><a href='../DeletePage?id=<%=rs.getString(1) %>'>DELETE</a></td>
					   </tr>
					   <% } }catch(Exception e){
						   
						 e.printStackTrace();  
					   } %>
					
</form>
</body>
</html>