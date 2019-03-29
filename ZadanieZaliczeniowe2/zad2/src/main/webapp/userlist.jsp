<%@page import="others.Links"%>
<%@page import="others.Attributes"%>
<%@page import="others.User"%>
<%@page import="java.util.ArrayList"%>
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


	<table border="1">
		<tr>
			<th>Nazwa</th>
			<th>Email</th>
			<th>Hasło</th>
			<th>Admin</th>
			<th>Premium</th>
			<th>Działanie</th>
		</tr>
		<%
			if (session.getAttribute(Attributes.currentUser) == null)
				return;

			ArrayList<User> users = (ArrayList<User>) session.getAttribute(Attributes.userList);
			for (User user : users) {
				out.print("<tr>");
				out.print("<td>" + user.getUserName() + "</td>");
				out.print("<td>" + user.getEmail() + "</td>");
				out.print("<td>" + user.getPassword() + "</td>");
				out.print("<td>" + user.isAdmin() + "</td>");
				out.print("<td>" + user.isPremium() + "</td>");

				if (user.isAdmin()) {
					out.print("<td></td>");
					out.print("</tr>");
				} else {
					out.print(
							"<td><a href=" + Links.changePremium + "?" + Attributes.username + "=" + user.getUserName()
									+ "&" + Attributes.changePremium + "=" + !user.isPremium() + ">Zmień</a></td>");
					out.print("</tr>");
				}

			}
		%>
	</table>
	<a href=<%=Links.logout%>>Logout</a>
	<br />
	<a href=<%=Links.premium%>>Premium site</a>
	<br />
	<a href=<%=Links.profile%>>See profile</a>
	<br />


</body>
</html>