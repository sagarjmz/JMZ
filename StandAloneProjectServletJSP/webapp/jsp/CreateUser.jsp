<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

input[type=reset] {
	width: 100%;
	background-color: red;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=reset]:hover {
	background-color: reds;
}
</style>
<body>
	<h3>Create User Form</h3>
	<div>
		<form action="../CreateUser" method="post">
			<label for="fname">Enter Full Name</label> <input type="text" id="fname"
				name=fname placeholder=Yourname..> <label for=lname>Enter
				Age</label> <input type="text" id="lname" name="age" placeholder="YourAge..">
			<label for="des">Enter Designation</label> 
			<select id="des" name="des">
				<option value="Programmer">Programmer</option>
				<option value="Tester">Tester</option>
				<option value="Manager">Manager</option>
				</select>
				<input type="submit" value="Submit">
				<input type="reset" value="Reset">
		</form>
	</div>
</body>
</html>
