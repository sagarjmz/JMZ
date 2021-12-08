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
<%
String str[]=(String[])session.getAttribute("list");
for(int i=0;i<str.length;i++){
	out.println(str[i]);
}
%>

</body>
</html>