<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL</h1>
${sessionScope.m }<br>
${sessionScope.m.get("first") }<br>
${sessionScope.m.get("last") }<br>
${sessionScope.m.get("third") }<br>
<h1>USING JSP</h1>
<% Map m=(Map)session.getAttribute("m"); %>
<%=m %>
</body>

</html>