<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
String myname=(String)pageContext.getAttribute("client",PageContext.SESSION_SCOPE); 
out.print(myname); 
  %> 

</body>
</html>