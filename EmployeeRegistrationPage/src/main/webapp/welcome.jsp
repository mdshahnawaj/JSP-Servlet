<!-- This is welcome page for display success message and submitted data -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome page</title>
</head>
<body style="align-content: center;">
	<div style="text-align: center;">
		<%-- Display success message and submitted values --%>

		<h1 style="color:green"><b><%= request.getAttribute("message") %></b></h1>
		<br><br>
		<h2>Display submitted data</h2>

		<table border="1" style="margin: 0 auto;">
		<tr>
			<td><b>First Name:</b></td>
			<td><%= request.getAttribute("firstName") %></td>
		</tr>
		<tr>
			<td><b>Last Name:</b></td>
			<td><%= request.getAttribute("lastName") %></td>
		</tr>
		<tr>
			<td><b>User Name:</b></td>
			<td><%= request.getAttribute("userName") %></td>
		</tr>
		<tr>
			<td><b>Password:</b></td>
			<td><%= request.getAttribute("password") %></td>
		</tr>
		<tr>
			<td><b>Address:</b></td>
			<td><%= request.getAttribute("address") %></td>
		</tr>
		<tr>
			<td><b>Contact:</b></td>
			<td><%= request.getAttribute("contact") %></td>
		</tr>
		</table>
		<br>
		<button><a href="registration.jsp" style="text-decoration: none">Home</a></button>
	</div>
</body>
</html>