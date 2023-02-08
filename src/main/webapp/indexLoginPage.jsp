<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Wellcome to Login Page</h1>
	<hr>
	<br>
	<form action = "login" method = "post">
		<pre>
			EmailId<input type= "text" name= "emailid"/>
			Password<input type= "password" name = "password"/>
			<br>
			<input type ="submit" value = "Login here"/>
		</pre>
	
	</form>
	<%if(request.getAttribute("invaild")!=null){
		out.println(request.getAttribute("invaild"));
	}
		%>
	
</body>
</html>