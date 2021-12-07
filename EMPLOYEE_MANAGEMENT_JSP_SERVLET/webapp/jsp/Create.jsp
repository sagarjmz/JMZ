<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<center>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: darkgrey;
  width: 50%;
  margin-left: 25%;
  margin-top: 5%;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%; 
  padding: 15px; 
  margin: 5px 0 22px 0; 
  display: inline-block; 
  border: none; 
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

</style>
</head>
<body>
<%ServletContext s = getServletContext();
String p = s.getInitParameter("p");
String m = s.getInitParameter("m");
String t = s.getInitParameter("t"); %>
<form action="../abcd">
  <div class="container">
  <h1>ENTER DETAILS</h1>
    <label for="uname"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="uname" required>

    <label for="age"><b>Age</b></label>
    <input type="text" placeholder="Enter Age" name="age" required>
<div style="width: 100%; padding: 15px; margin: 5px 0 22px 0; display: inline-block; border: none; background: #f1f1f1;">
     <label for="desig"><b>Designation</b></label><br><br>
    <input type="radio" id="Programmer" name="desig" value="programmer">
 <label style="color: red;" for="Programmer">Programmer (<%= p %>.00 Inr)</label><br>
 <input type="radio" id="Tester" name="desig" value="tester">
 <label style="color: red;" for="Tester">Tester (<%= t %>.00 Inr)</label><br>
 <input type="radio" id="Manager" name="desig" value="manager">
 <label style="color: red;" for="Manager">Manager (<%= m %>.00 Inr)</label>
 </div>
        
    <button class="registerbtn"type="submit">Create</button><br><br>
     <a href="Index.jsp"><button style="Background-color: red; width: 100%; cursor: pointer;  border: none; margin: 8px 0; padding: 16px 20px;" type="button">Back</button></a>
 
</form>

</body>
</html>