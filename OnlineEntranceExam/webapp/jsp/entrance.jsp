<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule Exam</title>
</head>
<body>
<h1>Exam Schedule Form</h1>
<Form action="../FileServlet" method="post">
Enter number of Questons : <input type="text" name="range"><br>
Enter Designation :
			<select name="language">
				<option value="Java">JAVA</option>
<!-- 				<option value="Sql">SQL</option> -->
<!-- 				<option value="Html">HTML</option> -->
				</select><br>
<input type="submit" value="Submit"></Form>

<!-- 
<table >
  <tr>
    <th>name</th>
    <th>roll no</th> 
    
  </tr>
  <tr>
    <td>${student.getName()}</td>
    <td>${student.getRollno()}</td> 
   
  </tr>
 
</table>


<h1>using toString()</h1>
  
${list}


<h1>using jstl for each</h1>

  <c:forEach items="${list}" var="s" >
   <br>
 ${s}<br>
 </c:forEach>
 -->

</body>
</html>
