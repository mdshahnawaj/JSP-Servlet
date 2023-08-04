/* This file is used for jquery validation */
/* This function is active when browser is load */
$(document).ready(function() {
	/* This function is used to validate first name */
	$("#firstname").on("input blur", function() {
		var firstName = $('#firstname').val();

		if (firstName == "") {
			$("#firstnameError").html("First name is required.");
		}
		else if ((firstName.length < 3) || (firstName.length > 20)) {
			$("#firstnameError").html("First name must be between 3 and 20 letters.");
		}
		else {
			$("#firstnameError").html("");
		}
	});

	/* This function is used to validate last name */
	$("#lastname").on("input blur", function() {
		var lastName = $('#lastname').val();

		if (lastName == "") {
			$("#lastnameError").html("Last name is required.");
		}
		else if ((lastName.length < 3) || (lastName.length > 20)) {
			$("#lastnameError").html("Last name must be between 3 and 20 letters.");
		}
		else {
			$("#lastnameError").html("");
		}
	});

	/* This function is used to allow only charecter in firstname, lastname */
	$("#firstname, #lastname").on("keypress", function(event) {
		var keyCode = event.which ? event.which : event.keyCode;

		if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || keyCode === 8) {
		}
		else {
			event.preventDefault();
		}
	});
	/* This function is used to validate user name */
	$("#username").on("input blur", function() {
		var username = $('#username').val();

		if (username == "") {
			$("#usernameError").html("Username is required.");
		}
		else if ((username.length < 3) || (username.length > 20)) {
			$("#usernameError").html("Username must be between 3 and 20 characters.");
		}
		else {
			$("#usernameError").html("");
		}
	});

	/* This function is used to validate password */
	$("#password").on("input blur", function() {
		var passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/;
		var password = $('#password').val();

		if (password == "") {
			$("#passwordError").html("Password is required.");
		}
		else if (password.length < 8) {
			$("#passwordError").html("Password must be 8 characters.");
		}
		else if (!password.match(passwordPattern)) {
			$('#passwordError').html('Password must be strong(demo@123).')
		}
		else {
			$("#passwordError").html("");
		}
	});

	/* This function is used to show/hide password */
	$(".show-password-checkbox").click(function() {
		var passwordInput = $("#password");

		if (passwordInput.attr("type") === "password") {
			passwordInput.attr("type", "text");
			$(this).removeClass("fa-eye-slash").addClass("fa-eye");
		}
		else {
			passwordInput.attr("type", "password");
			$(this).removeClass("fa-eye").addClass("fa-eye-slash");
		}
	});

	/* This function is used to validate address */
	$("#address").on("input blur", function() {
		var address = $('#address').val();

		if (address == "") {
			$("#addressError").html("Address is required.");
		}
		else if (address.length < 20) {
			$("#addressError").html("Address must be 20 characters.");
		}
		else {
			$("#addressError").html("");
		}
	});

	/* This function is used to validate contact */
	$("#contact").on("input blur", function() {
		var contact = $('#contact').val();

		if (contact == "") {
			$("#contactError").html("Contact number is required.");
		}
		else if ((contact.length < 10) || (contact.length > 17)) {
			$("#contactError").html("Contact number must be between 10 to 17 digit.");
		}
		else {
			jQuery.ajax({
				url: "EmployeeServlet",
				data: { contactNo: contact },
				type: "POST",
				success: function(response) {
					if (response === "true") {
						$("#contactError").html("Contact number is already exists!");
						$('#registerButton').prop('disabled', true);
					}
					else {
						$("#contactError").html("");
					}
				}
			});
		}
	});

	/* This function is used to allow only digit */
	$("#contact").on("keypress", function(event) {
		var keyCode = event.which ? event.which : event.keyCode;
		if (keyCode < 48 || keyCode > 57) {
			event.preventDefault();
		}
	});

	/* This function in used to enable/disable registration button */
	function enableDisableRegisterButton() {
		var firstName = $('#firstname').val();
		var lastName = $('#lastname').val();
		var username = $('#username').val();
		var password = $('#password').val();
		var address = $('#address').val();
		var contact = $('#contact').val();

		if (firstName !== '' && lastName !== '' && username !== '' && password !== '' && address !== '' && contact !== '' &&
			firstName.length >= 3 && firstName.length <= 20 &&
			lastName.length >= 3 && lastName.length <= 20 &&
			username.length >= 3 && username.length <= 20 &&
			password.length >= 8 &&
			address.length >= 20 &&
			contact.length >= 10 && contact.length <= 17) {
			$('#registerButton').prop('disabled', false);
		}
		else {
			$('#registerButton').prop('disabled', true);
		}
	}
	$('#firstname, #lastname, #username, #password, #address, #contact').keyup(enableDisableRegisterButton);
});