<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<form action="UserListCtl" method="post">
		<h1 align="center">User List</h1>
		<%
			List list = (List) request.getAttribute("list");
			String msg = (String) request.getAttribute("msg");
		%>

		<%
			if (msg != null) {
		%>

		<h3 align="center"><%=msg%></h3>

		<%
			}
		%>
		<center>

			<table>
				<tr>
					<td><input type="type" name="firstName"
						placeholder="Search by firstname"> &nbsp <input
						type="text" name="lastName" placeholder="Search by lastName">
						&nbsp <input type="text" name="login"
						placeholder="Search by login"> &nbsp <input type="date"
						name="dob"> &nbsp <input type="submit" value="Search"
						name="operation"></td>
				</tr>
			</table>
			<br>
			<table border="1px" width="100%">

				<tr style="background-color: #3f4a2b; color: white;">

					<th>Delete</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>LoginId</th>
					<th>DOB</th>
					<th>Edit</th>

				</tr>

				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>

				<tr align="center" style="background-color: #c4c777">

					<td><input type="checkbox" value="<%=bean.getId()%>"
						name="ids"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl?id=<%=bean.getId()%>">edit</a></td>

				</tr>
				<%
					}
				%>
			</table>
			<br>
			<table>
				<tr>
					<input type="submit" value="Delete" name="operation">
				</tr>
			</table>
		</center>
	</form>
</body>
</html>