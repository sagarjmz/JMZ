<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
int i;
public void jspInit(){
	i=10;
}
public void jspDestroy(){
	i=21;
}
%>
<%
out.println("init i value is : "+i);
jspDestroy();
out.println("destroy i value is : "+i);
%>
</body>
</html>