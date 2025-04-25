<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<h1 align="center">Add User</h1>

	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (msg != null) {
	%>

	<h3 align="center"><%=msg%></h3>

	<%
		}
	%>

	<form action="AddUserCtl" method="post">
		<center>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter first name" required="required"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Last name"></td>
				</tr>
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
					<th>DOB</th>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="save" name="operation"></td>
				</tr>
			</table>
		</center>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>