<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
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
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="form">
				<form action="LoginsecurityController" method="post">
					<div
						style="text-align: center; font-family: bolder; color: #f89501;">
						<h1 style="font-size: 50px;">MyGate</h1>
					</div>
					<div style="text-align: center;">
						<h1 style="font-size: 30px;">Login page</h1>
						<p style="color: red;">${msg}</p>
						<h4 style="color: red;">${activate}</h4>
						<br>
					</div>
					
					<div class="form-group">
						<input type="number" placeholder="phone number" name="number"
							class="form-control">
					</div>
					<div class="form-group">
						<input type="text" placeholder="Password" name="password"
							class="form-control">
					</div>
					<div style="text-align: center;">
						<input type="submit" value="submit" class="btn btn-primary">
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>