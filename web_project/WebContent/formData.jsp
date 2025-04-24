<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Data</title>
</head>
<body>
	<h1><%=request.getParameter("firstName")%></h1>
	<h1><%=request.getParameter("lastName")%></h1>
	<h1><%=request.getParameter("login")%></h1>
	<h1><%=request.getParameter("password")%></h1>
	<h1><%=request.getParameter("dob")%></h1>
</body>
</html>