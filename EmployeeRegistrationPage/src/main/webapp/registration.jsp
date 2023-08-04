<!--
	This is JSP page is used for employee registration form
	@author MdShahnawaj
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee Register Form</title>
	<link rel="stylesheet" href="registration.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<form action="EmployeeServlet" method="post" target="_blank" id="registrationForm">
	<div class="container">
		<h1 id ="hadding">Employee Register Form</h1>
		<hr>
		<label for="first_name"><b>First Name*</b></label>
		<div>
			<input type="text" placeholder="Enter your first name" name="firstName" id="firstname" autocomplete="off">
		</div>
		<span id="firstnameError" class="fnameerror" style="color: red;"></span><br>

		<label for="last_name"><b>Last Name*</b></label>
		<div>
			<input type="text" placeholder="Enter your last name" name="lastName" id="lastname" autocomplete="off">
		</div>
		<span id="lastnameError" style="color: red;"></span><br>

		<label for="user_name"><b>User Name*</b></label>
		<div>
			<input type="text" placeholder="Enter your user name" name="userName" id="username" autocomplete="off">
		</div>
		<span id="usernameError" style="color: red;"></span><br>

		<label for="password"><b>Password*</b></label>
		<div class="password-container">
			<input type="password" placeholder="Enter your password" name="password" id="password" autocomplete="off">
			<i class="fas fa-eye-slash show-password-checkbox"></i>
		</div>
		<span id="passwordError" style="color:red;"></span><br>

		<label for="address"><b>Address*</b></label>
		<div>
			<input type="text" placeholder="Enter your address" name="address" id="address" autocomplete="off" >
		</div>
		<span id="addressError" style="color: red;"></span><br>

		<label for="contact"><b>Contact No*</b></label>
		<div>
			<input type="text" placeholder="Enter your contact" name="contact" id="contact" autocomplete="off">
		</div>
		<span id="contactError" style="color: red;"></span><br>
		<hr>
		<button type="submit" class="registerbtn" id="registerButton" disabled>Submit</button>
	</div>
</form>
<script type="text/javascript" src="jquery.js"></script>
</body>
</html>