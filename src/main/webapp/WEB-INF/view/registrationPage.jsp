<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file = "mean.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h2>Welcome To Registration Page</h2>
	<hr>
	<br>
	<form action = "reg" method = "post">
		<table border='1'>
			<tr>
				<td>Name</td>
				<td><input type = "text" name = "name"/></td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td><input type = "text" name = "emailid"/></td>
			</tr>
			<tr>
				<td>MobileNumber</td>
				<td><input type = "number" name = "mobile"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type = "password" name = "password"/></td>
			</tr>
			<tr><td><input type = "submit" name = "Save Data"/></td></tr>
		
		</table>
	<%if(request.getAttribute("save")!=null){
		out.println(request.getAttribute("save"));
	}
		%>
	
	</form>
</body>
</html>