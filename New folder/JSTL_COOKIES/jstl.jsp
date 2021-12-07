<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USING EL-(EXPRESSION LANGUAGE)<br></h1>
COMPANY NAMEe : ${param.company }<br>
SALARY : ${param.salary }<br>
FIRST NAME : ${cookie.fname.value }<br>
LAST NAME : ${cookie.lname.value }<br>



<h1>using scriptlet</h1><br>

<%String fname;
String lname;
Cookie c;
Cookie c1;
Cookie arr[]=request.getCookies();
c=arr[0];
c1=arr[1];
fname=c.getValue();
lname=c1.getValue();
%>

FIRST NAME : <%= fname%><BR>
LAST NAME : <%= lname%><BR>
COMPANY NAME : <%= request.getParameter("company")%><BR>
SALARY  : <%= request.getParameter("salary")%><BR>


</body>
</html>