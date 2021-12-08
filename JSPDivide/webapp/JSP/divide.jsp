<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="divideError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String num1=request.getParameter("number1");
String num2=request.getParameter("number2");
int a=Integer.parseInt(num1);
int b = Integer.parseInt(num2);
int result=a/b;
%>
<h1>Division of numbers<%= result %></h1>
</body>
</html>