<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>OUTPUT OF REQUEST</h1>
<%  
String name=request.getParameter("uname"); 
String pass=request.getParameter("pwd");
out.print("Welcome  "+name+" "+pass); 
%>
</body>
</html>