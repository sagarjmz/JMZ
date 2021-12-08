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
Cookie FNAMEs[]=request.getCookies();
%>
<%!String fname=null;
String lname=null;%>
<%=request.getParameter("compname") %>
<%=request.getParameter("sal") %>
<%
for(int i=0;i<FNAMEs.length;i++){
	if(FNAMEs[i].getName().equalsIgnoreCase("fname")){
		fname=FNAMEs[i].getValue();
	}
	if(FNAMEs[i].getName().equalsIgnoreCase("lname")){
		lname=FNAMEs[i].getValue();
	}
}
%>
<%=fname %>
<%=lname %>
</body>
</html>