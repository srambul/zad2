<%@page import="others.Attributes"%>
<%@page import="others.Links"%>
<%@page import="others.User"%>
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
	<%
		User user = (User) session.getAttribute(Attributes.currentUser);
		if (user.isAdmin())
			out.print("<a href=" + Links.userlist + "> Users list </a>");

		if (user.isAdmin() || user.isPremium())
			out.print("<a href=" + Links.premium + "> Premium site </a>");
		
		out.print("<a href=" + Links.logout + "> Logout </a><br/>");

		out.print("Email: " + user.getEmail() + "<br/>");
		out.print("Username: " + user.getUserName() + "<br/>");
		out.print("Password: " + user.getPassword() + "<br/>");
		out.print("Premium: " + user.isPremium() + "<br/>");
		out.print("Admin: " + user.isAdmin() + "<br/>");
	%>
</body>
</html>