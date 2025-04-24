<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<hr>
	<h1 align="center">Login</h1>

	<form action="LoginCtl" method="post">
		<center>
			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login"
						placeholder="Enter Login id" required="required"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="Enter Password" required="required"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Signin" name="operation"></td>
				</tr>
			</table>
		</center>
	</form>
	<hr>
	<%@ include file="Footer.jsp"%>
</body>
</html>