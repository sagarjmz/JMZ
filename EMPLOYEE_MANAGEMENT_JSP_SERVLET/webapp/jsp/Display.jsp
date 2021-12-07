<%@page import="com.TO.Employee"%>
<%@page import="java.sql.*"%>
<%@page import="com.DB.DBClass"%>
<%@ page errorPage="jsp/ErrorPage.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <center>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>details</title>
  </head>
  <% 
  request.getRequestDispatcher("/DBClass").include(request, response);
	ResultSet rs;
	
		Connection con = DBClass.con;
		Statement st = con.createStatement();
		
	%>
  <body>
    <h1 style="color: red;">EMPLOYEE DETAILS!</h1><br><br>
    <table class="table table-dark" style="width: 95%">
  <thead>
    <tr>
      <th scope="col">SN</th>
      <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">AGE</th>
      <th scope="col">DESIGNATION</th>
      <th scope="col">SALARY</th>
      <th scope="col">EDIT</th>
      <th scope="col">DELETE</th>
    </tr>
  </thead>
  <tbody>
  
  <% int i=1;%>
  
 <%Employee e = new Employee();
 rs = st.executeQuery("SELECT * FROM finalemp");
 while (rs.next()) 
  { 
      e.setEmpId(rs.getString("empId"));  
      e.setName(rs.getString("name")); 
      e.setDesignation(rs.getString("designation"));
      e.setage(rs.getInt("age"));
      e.setSalary(rs.getInt("salary")); 
   
    %>
    <tr>
      <th scope="row"><%=i++ %></th>
      <td><%=e.getEmpId() %></td>
      <td><%=e.getName() %></td>
      <td><%=e.getage() %></td>
      <td><%=e.getDesignation() %></td>
      <td><%=e.getSalary() %></td>
      <td><a style="color: blue" href='Raise.jsp?id=<%=e.getEmpId()%>&&sal=<%=e.getSalary()%>'>EDIT</a></td>
      <td><a style="color: red" href='../Delete?id=<%=e.getEmpId()%>'>REMOVE</a></td>
    </tr>
   
    <%
    }

    %>
   
    
  </tbody>
</table><br>
<form action="Index.jsp">
<button class = "btn btn-danger">Back</button>
</form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>