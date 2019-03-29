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
	<a href=<%=Links.login%>>Login</a>
	<form action=<%=Links.tryRegister%> method="post">
		<p>
			Username: <br /> <input title="Enter your username" type="text"
				required pattern="\w+" name=<%=Attributes.username%>>
		</p>
		<p>
			Password:<br /> <input
				title="Password must contain at least 6 characters, including UPPER/lowercase and numbers"
				type="password" required 
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name=<%=Attributes.password%>
				onchange="
  				this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
  				if(this.checkValidity()) form.pwd2.pattern = RegExp.escape(this.value);">
		</p>
		<p>
			Confirm Password:<br /> <input
				title="Please enter the same Password as above" type="password"
				required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd2"
				onchange="
  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');">
		</p>

		<p>
			Email: <br /> <input type="email" name=<%=Attributes.email%>  /> <br />
		</p>
		<input type="submit" value="Register !" />
	</form>

	<%
		if (request.getAttribute(Attributes.regAnswer) != null)
			out.print(request.getAttribute(Attributes.regAnswer));
	%>

</body>
</html>