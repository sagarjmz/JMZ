<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${sessionScope.list }<br>
${sessionScope.list[0] }<br>
${sessionScope.list[1 ]}<br>
${sessionScope.list[2 ]}<br>
${sessionScope.list[3] }<br>
<h1>USING JSP</h1>
<% ArrayList arr=(ArrayList)session.getAttribute("list"); %>
<%=arr %>
<%=arr.get(0) %><br>
<%=arr.get(1) %><br>
<%=arr.get(2) %><br>
<%=arr.get(3) %><br>
<%-- <%=arr[1] %><br>
<%=arr[2] %><br>
<%=arr[3] %><br> --%>
</body>
</html>