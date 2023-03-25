<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="verifyLogin" method="post">
	<table>
		  <tr>
		    <td>Email</td>
		    <td><input type="text" name="emailId"/></td>
		  </tr>
		  <tr>
		    <td>Password</td>
		    <td><input type="password" name="password"/></td>
		  </tr>
		  <tr>
		    <td><input type="submit" value="login"/></td>
		  </tr>
		</table>

	</form>
	${msg}
</body>
</html>