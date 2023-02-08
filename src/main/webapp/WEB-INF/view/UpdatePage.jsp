<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file = "mean.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
 <form action = "update" method = "post">
 	<pre>
 		
 		 EmailId<input type = "text" name = "emailid" value= "<%=request.getAttribute("emailid")%>"/>
 		 Mobile<input type = "number" name = "mobile" value= "<%=request.getAttribute("mobile")%>"/>
 		 Name<input type = "text" name = "name" value= "<%=request.getAttribute("name")%>"/>
 		 password<input type = "text" name = "password" value= "<%=request.getAttribute("password")%>"/>
 		 <br>
 		 <input type = "submit" value = "Update Data"/>
 		
 	</pre>
 
 </form>
</body>
</html>