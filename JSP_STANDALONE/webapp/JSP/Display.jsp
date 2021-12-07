<%@ page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic","root","root");
	Statement stmt=con.createStatement();%>
	
	<form action="../Display" method="">  
	<p style=\color:red;\><h2>EMPLOYEES DETAILS DATA.....</h2></p>    <table>
	  <tr>      <th>EMP_ID</th>      <th>EMP_NAME</th>
	    <th>EMP_AGE</th>      <th>EMP_DESIGNATION</th>      <th>EMP_SALARY</th> <th>EDIT</th><TH>DELETE</TH>
	  </tr>
	 <%  ResultSet rs=stmt.executeQuery("SELECT * FROM new_table");
	 while (rs.next())
     {  
         String id = rs.getString("empid");  
         String name = rs.getString("empname");
         int age = rs.getInt("empage");
         String deg = rs.getString("designation");
         int sal = rs.getInt("empsalary");  
        %>
<tr>
  <td><%=id %></td>
  <td><%=name %></td>
  <td><%=age %></td>
  <td><%=deg%></td>
  <td><%=sal %></td>
  <td><a href='./RaiseSalary.jsp?id=<%=id%>&salary=<%=sal%>'>Raisesalary </a></td>
    <td><a href='../Delete?id=<%=rs.getString(1)%>'>DELETE </a></td>
  </tr>
 <% }}catch(Exception e){
 
e.printStackTrace();  
  } %>

</form>
</body>
</html>