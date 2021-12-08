<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>USING JSTL</H1>
STRING_ARRAY OBJECT : ${sessionScope.stringArr}<br>
STRING_ARRAY[0] : ${sessionScope.stringArr [0]}<br>
STRING_ARRAY[1] : ${sessionScope.stringArr[1] }<br>
STRING_ARRAY[2] : ${sessionScope.stringArr[2] }<br>
STRING_ARRAY[3] : ${sessionScope.stringArr[3] }<br>
STRING_ARRAY[4] : ${sessionScope.stringArr[4] }<br>

<H1>USING JSP</H1>
<%String arr[]=(String[])session.getAttribute("stringArr"); %><br>
STRING_ARRAY OBJECT= <%=arr %> <br>
STRING_ARRAY[0] = <%=arr[0] %> <br>
STRING_ARRAY[1] = <%=arr[1] %> <br>
STRING_ARRAY[2] = <%=arr[2]%> <br>
STRING_ARRAY[3] = <%=arr[3] %> <br>
STRING_ARRAY[4] = <%=arr[4] %> <br>
</body>
</html>