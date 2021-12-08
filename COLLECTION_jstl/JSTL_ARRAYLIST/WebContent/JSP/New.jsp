<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USING JSTL</h1>
${sessionScope.ArrList }<br>
${sessionScope.ArrList[0] }<br>
${sessionScope.ArrList[1] }<br>
${sessionScope.ArrList[2] }<br>
${sessionScope.ArrList[3] }<br>


<h1>using jsp </h1>

<% ArrayList a = (ArrayList)session.getAttribute("ArrList") ; %><br>
<%= a.get(0) %><br>
<%= a.get(1) %><br>
<%= a.get(2) %><br>
<%= a.get(3) %><br>



</body>
</html>