<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
USING EL
Company name:${param.compname }<br>
Salary:${param.sal }<br>
FirstName:${cookie.fname.value }<br>
LastNAme:${cookie.lname.value }<br>
</h1>
</body>
</html>