<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
print numbers from 1 to 100 using for each tag<BR>
<c:forEach begin="1" step="5" end="100" var="x">
<c:out value="${x }"/>
</c:forEach>
</body>
</html>