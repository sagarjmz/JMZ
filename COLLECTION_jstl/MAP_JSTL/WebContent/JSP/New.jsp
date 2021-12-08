<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USING JSTL</h1>

whole maplist : ${sessionScope.map }<br>
map(1) : ${sessionScope.map.get("1")}<br>
map(2) : ${sessionScope.map.get("2")}<br>
map(3) : ${sessionScope.map.get("3")}<br>
map(4) : ${sessionScope.map.get("4")}<br>
</body>
</html>