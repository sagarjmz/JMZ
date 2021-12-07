<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
	box-sizing: border-box;
}

.menu {
	float: left;
	width: 20%;
	text-align: center;
}

.menu a {
	background-color: #e5e5e5;
	padding: 8px;
	margin-top: 7px;
	display: block;
	width: 100%;
	color: black;
}

.main {
	float: left;
	width: 60%;
	padding: 0 20px;
}

.right {
	background-color: #e5e5e5;
	float: left;
	width: 20%;
	padding: 15px;
	margin-top: 7px;
	text-align: center;
	font-size: 63px
}

@media only screen and (max-width: 620px) {
	/* For mobile phones: */
	.menu, .main, .right {
		width: 100%;
	}
}
</style>
</head>
<body style="font-family: Verdana; color: #34495E;">

	<div
		style="text-decoration: underline; height: 90px; background-color: #05c3e4; width: 100%; padding: 15px; text-align: center;">
		<h1>JMZ &nbsp;TECHNOLOGIES &nbsp;PRIVATE &nbsp;LIMITED</h1>
	</div>

	<div style="overflow:">
		<div class="menu">
			<a style="background-color: #85C1E9; color: #34495E; font-weight: bold; font-size: 24px; text-decoration: none"
				href="Create.jsp">CREATE</a> <a
				style="background-color: #58D68D; color: #34495E; font-weight: bold; font-size: 24px; text-decoration: none"
				href="Display.jsp">DISPLAY</a> <a
				style="background-color: tomato; color: #34495E; font-weight: bold; font-size: 24px; text-decoration: none"
				href="../HTML/NewLogin.html">LOGOUT</a> <a
				style="background-color: white; margin-left: -6px"></a>
		</div>

		<div class="main"
			style="background-color: #28d; background-repeat: no-repeat; width: 60%; height: 100%; position: relative; margin-top: 1px; border: 11px solid white; color: cyan;">
			 <br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
<%HttpSession session1 = request.getSession();
Object a = session.getAttribute("a"); %>

		</div>

		<div style="color: white; background-color: white" class="right">
			<p style="font-size: 56px; color: #34495E; background-color: #05c3e4; width: 110%; height: 80px; margin-top: -3%; margin-left: -5%; text-align: center;">hi,<%=a %></p>
			

		</div>
	</div>

	<div
		style="color: black; background-color: #05c3e4; text-align: center; padding: 10px; margin-top: 40%;">suhelsahu423@gmail.com</div>

</body>
</html>