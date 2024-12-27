<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
<link rel="stylesheet" type="text/css" href="Signup.css">
</head>
<body>
<form action="Signup" method="post">
<h1>Sign Up</h1>
<br>
<input type="text" placeholder="Username" name="name">
<br>
<br><input type="email" placeholder="Email" name="email"><br>
<br><input type="password" placeholder="Password" name="password"><br>
<br><input type="text" placeholder="Contact" name="contact"><br>
<br>
<a href="Signin.jsp">Login</a>
<br>
<input type="submit">
</form>
</body>
</html>