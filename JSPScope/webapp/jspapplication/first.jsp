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
String myname=request.getParameter("username"); 
out.print("Welcome "+myname); 
  pageContext.setAttribute("client",myname,PageContext.SESSION_SCOPE);  %>
  <a href="second.jsp"> go to second jsp page</a>
</form>
</body>
</html>