<%@page import="com.pojopackage.Pojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>using jstl</h1>
${sessionScope.Pojo.id }
${sessionScope.Pojo.name }
${sessionScope.Pojo.phone }

<h1>using jsp</h1>
<%Pojo p=(Pojo)session.getAttribute("Pojo"); %><br>
<%=p.getId() %><br>
<%=p.getName() %><br>
<%=p.getPhone() %>
</body>
</html>