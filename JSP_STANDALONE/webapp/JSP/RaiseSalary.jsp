<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Raise salary</h1>
	<form action="../RaiseSalary" method="post">
		<div class="container">
			<label for="percentage"><b>Percentage</b></label> <input type="text"
				placeholder="Enter Percentage to RaiseSalary" name="percentage"
				required> <input type="hidden" name="id"
				value="<%=request.getParameter("id")%>"> <input
				type="hidden" name="salary"
				value="<%=request.getParameter("salary")%>">
			<button type="submit">Submit</button>

		</div>

		<div class="container" style="background-color: teal\"></div>

	</form>

</body>

</html>
</body>
</html>