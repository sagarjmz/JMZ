<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="myForm" id="myForm" action="/www.facebook.com" method="POST">
  <p>
  <input name="test" value="test" />
  </p>
  <p>
    <input type="submit" value="Submit" />
  </p>
</form>

    <script>

    var auto_refresh = setInterval(
    function()
    {
    submitform();
    }, 10000);

    function submitform()
    {
    
      document.myForm.submit();
    }
    </script>
</body>
</html>