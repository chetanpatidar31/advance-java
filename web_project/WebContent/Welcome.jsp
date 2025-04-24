<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<hr>
	<h1 align="center">Online Result System</h1>
	<h2 align="center">
		<em>Under Maintenance</em>
	</h2>

	<%
		String msg = (String) request.getAttribute("msg");
	%>

	<%
		if (msg != null) {
	%>

	<h3 align="center"><%=msg%>
	</h3>

	<%
		}
	%>

	<%@ include file="Footer.jsp"%>
</body>
</html>