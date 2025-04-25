<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		<%="Hii, " + user.getFirstName()%>
		<br> 
		<a href="AddUserCtl">Add User</a> | 
		<a href="UserListCtl">User List</a> | 
		<a href="LoginCtl?operation=logout">Logout</a>
	</h3>
	<%
		} else {
	%>
	<h3>Hii, Guest..</h3>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="LoginCtl">Login</a>
	<%
		}
	%>
	<hr>
</body>
</html>