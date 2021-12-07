<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=pink>
<form action="../RaiseSalaryPage" method=""> 
<label ><b> Enter Percentage to Raise Salary :</b></label>
 <input type=text name=percentage></input>
 
  <input type="hidden" name="id" value='${param.id }'></input>
 <input type="hidden" name="sal" value='${param.sal }'></input>
 
 <%-- <input type="hidden" name="id" value='<%=request.getParameter("id") %>'></input>
 <input type="hidden" name="sal" value='<%=request.getParameter("sal") %>'></input> --%>
 
<button type="submit">Submit</button>          
</form>
</body>
</html>