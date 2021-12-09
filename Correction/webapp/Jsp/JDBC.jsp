<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="Error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connection Page</title>
</head>
<body>
	<center>
		<h1>


			<%
			Connection con;
			String url = "jdbc:mysql://localhost:3306/jsp";
			String user = "root";
			String password = "Ailesh@22";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String pass = request.getParameter("pass");
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, pass);

			int r = ps.executeUpdate();
			if (r == 1) {
				out.println("Submitted");
			} else {

			}
			%>
		
</body>
</html>