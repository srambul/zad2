<%@page import="others.Attributes"%>
<%@page import="others.Links"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zadanie 2</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<a href=<%=Links.home%>>Home</a>
	<a href=<%=Links.register%>>Register</a>
	<form action=<%=Links.tryLogin%> method="post">
		Username: <br /> <input type="text" name=<%=Attributes.username%> /> <br />
		Password: <br /> <input type="password" name=<%=Attributes.password%> />
		<br /> <input type="submit" value="Login !">
	</form>
	
		<%
		if (request.getAttribute(Attributes.loginAnswer) != null)
			out.print(request.getAttribute(Attributes.loginAnswer));
	%>
</body>
</html>