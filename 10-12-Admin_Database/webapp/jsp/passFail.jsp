<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid blue;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color:;
}
</style>
</head>
<body>
	<center>
		<form>
			<h1>PASSED CANDIDATE RESULTS</h1>
			<table style="border: 1px solid black">
				<tr>
					<th>Sl_No</th>
					<th>Candidate_Id</th>
					<th>Candidate_Results</th>
					<th>Date</th>
					<th>Remove</th>
				</tr>

				<%
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "root");
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("SELECT * FROM candidate_reg");
					while (rs.next()) {
						int sl = rs.getInt("sl_no");
						String id = rs.getString("candidate_id");
						int result = rs.getInt("candidate_res");
						String date = rs.getString("date");
						int s = 1;
						if (result >= 7) {

					out.println("<tr><td>" + sl + "</td><td>" + id + "</td><td>" + result + "</td><td>" + date
							+ "</td><td><a href=../Delete?candidate_id=" + rs.getString(2) + ">Delete</a></td></tr>");

						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
			</table>

			<h1>FAILED CANDIDATE RESULTS</h1>
			<table style="border: 1px solid black">
				<tr>
					<th>Sl_No</th>
					<th>Candidate_Id</th>
					<th>Candidate_Results</th>
					<th>Date</th>
					<th>Remove</th>
				</tr>

				<%
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "root");
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("SELECT * FROM candidate_reg");
					while (rs.next()) {
						int sl = rs.getInt("sl_no");
						String id = rs.getString("candidate_id");
						int result = rs.getInt("candidate_res");
						String date = rs.getString("date");
						int i = 1;
						if (result < 7) {

					out.println("<tr><td>" + sl + "</td><td>" + id + "</td><td>" + result + "</td><td>" + date
							+ "</td><td><a href=../Delete?candidate_id=" + rs.getString(2) + ">Delete</a></td></tr>");
					i++;
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
			</table>
		</form>
	</center>
</body>
</html>