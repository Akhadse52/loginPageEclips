<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@include file = "mean.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Data</title>
</head>
<body>

	<h2>All Registration data Details</h2>

	<table border='1'>
		<tr>
			<th>Name</th>
			<th>EmailId</th>
			<th>MobileNumber</th>
			<th>Passsword</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		ResultSet result = (ResultSet) request.getAttribute("result");
		while (result.next()) {
		%>

		<tr>
			<td><%=result.getString(1)%></td>
			<td><%=result.getString(2)%></td>
			<td><%=result.getString(3)%></td>
			<td><%=result.getString(4)%></td>
			<td><a href = "delete?email=<%=result.getString(2)%>">Delete</a></td>
			<td><a href = "update?email=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>&name=<%=result.getString(1)%>&password=<%=result.getString(4)%>">Update</a></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>