<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
 <a:set var="c" value="${param.num}" />
<a:if test="${c%2 == 0}" >
even Number<br>
</a:if>
<a:if test="${c%2 != 0}" >
Odd Number<br>
</a:if> 
</body>
</html>