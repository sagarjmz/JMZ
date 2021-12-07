<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="com.jmz.pojo.PersonId" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<%PersonId person=new PersonId();
person =(PersonId)request.getAttribute("pto");

%>
UserName:  <%=person.getName() %><br><br>
Password:  <%=person.getPassword() %><br><br>
Phone:  <%=person.getPhonenumber() %><br><br>
Email:  <%=person.getEmail() %><br><br>
</table>
</center>
</body>
</html>