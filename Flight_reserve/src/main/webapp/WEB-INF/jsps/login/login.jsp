<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<h2>Log in</h2>

${error}
<pre>
  <form action="verifyLogin" method="post">
  Email    : <input type="text" name="emailId"/>
  password : <input type="password" name="password">

<input type = "submit" value="login">
  
  
  </form>
</pre>
</body>
</html>