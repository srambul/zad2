<%@page import="others.Links"%>
<%@page import="others.Attributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="others.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zadanie 2</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<a href=<%=Links.logout%>>Logout</a>
	<a href=<%=Links.profile%>>Profile</a>


	<%
		User user = (User) session.getAttribute(Attributes.currentUser);
		if (user.isAdmin())
			out.print("<a href= " + Links.userlist + " >Users</a>");
	%>
	<br/>
	Premium Site
	<br />
</body>
</html>