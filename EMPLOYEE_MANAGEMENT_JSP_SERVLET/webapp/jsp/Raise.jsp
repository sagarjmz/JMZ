<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
.registerbtn2 {
  background-color: red;
  color: black;
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

<form action="../abcdef">
  <div class="container">
    

    <label for="percentage"><b>Percentage</b></label><br><br>
    <input  type="text" placeholder="Enter Percentage" name="percentage" required>
    <input type="hidden" name = "id" value= '<%=request.getParameter("id") %>'>
    <input type="hidden" name = "sal" value= '<%=request.getParameter("sal") %>'>

     
        
    <button class="registerbtn"type="submit">Raise</button><br>
    <a href="Display.jsp" ><button class="registerbtn2"type="button">Back</button></a>
 
</form>

</body>
</html>