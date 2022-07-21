<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add security</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: whitesmoke;
}

#form {
	background-color: white;
	hight: 250px;
	width: 200px;
	border-radius: 25px;
}
</style>

</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4"></div>
			<div class="col-md-4 pt-3 pb-3"
				style="border: 1px solid black; border-radius: 20px; background-color: white;">

				<form action="AddsecurityController" method="post">

					<div style="text-align: center;">
						<h1 style="font-size: 30px;">add security</h1>
					</div>
					<div style="text-align: center;">
						<h1 style="font-size: 30px;">${msg}</h1>
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
						<input type="password" placeholder="password" name="password"
							class="form-control"/>${passwordError}
					</div>
					<div class="form-group">
						<input type="tel" placeholder="contect number"
							class="form-control" name="contact_number" value="${numbervalue}" />${numberError}
					</div>
					<br> <br>
					<div style="text-align: center;">
						<input type="submit" value="Add" class="btn btn-primary" />
					</div>

				</form>


			</div>

		</div>
	</div>

</body>
</html>