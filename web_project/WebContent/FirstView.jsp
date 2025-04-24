<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FirstView</title>
</head>
<body>
	<form action="FirstServlet" method="post">
		<center>
			<h1>FirstView</h1>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter first name"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Last name"></td>
				</tr>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login"
						placeholder="Enter Login id"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob" placeholder="Choose dob"></td>
				</tr>
				<tr>
					<th>Click here</th>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>