<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
<div class="controller">

	<%
	String genderError = (String) request.getAttribute("genderError");

	String gendervalue = (String) request.getAttribute("gendervalue");
	%>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="SignupController" method="post">
					<div
						style="text-align: center; font-family: bolder; color: #f89501;">
						<h1 style="font-size: 50px;">MyGate</h1>
					</div>
					<div style="text-align: center;">
						<h1 style="font-size: 30px;">Signup</h1>
					</div>
					<div class="form-group">
						<input type="text" placeholder="firstname" name="firstname"
							class="form-control" value="${firstnamevalue}" />${firstnameError}
					</div>
					<div class="form-group">
						<input type="text" placeholder="lastname" name="lastname"
							class="form-control" value="${lastnamevalue}" />${lastnameError}
					</div>
					<div class="form-group">
						<input type="email" placeholder="email" name="email"
							class="form-control" value="${emailvalue}" />${emailError}${emailduplicateError}
					</div>
					<div class="form-group">
						<input type="password" placeholder="password" class="form-control"
							name="password" value="${passwordvalue}" />${passwordError}
					</div>
					<div class="form-group">
						<input type="tel" placeholder="contect number" class="form-control"
							name="contact_number" value="${numbervalue}" />${numberError}
					</div>
					
					<div class="form-check">
						male:<input type="radio" value="male" name="gender"
							<%=gendervalue != null && gendervalue.equals("male") ? "checked" : ""%> />
						female:<input type="radio" value="female" name="gender"
							<%=gendervalue != null && gendervalue.equals("female") ? "checked" : ""%> />
					</div>
					<br> <br>
					<div style="text-align: center;">
						<input type="submit" value="Signup" class="btn btn-primary" />
					</div>
					<div style="text-align: center; text-decoration: none">
						<a href="login.jsp">login</a>
					</div>
				</form>
			</div>
		</div>
	</div>

</div>

</body>
</html>