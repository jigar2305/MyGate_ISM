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
	color: white;
}

#hh {
	text-align: center;
	height: 690px;
}

#h {
	padding: 300px;
}

a {
	justify-content: center;
	text-align: center;
	color: white;
	text-decoration: none !important;
}
a:hover {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"
				style="background-color: black; height: 50px; font-family: bolder; color: white; text-align: center;">
				<h1>MyGate</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6" id="hh" style="background-color: green;">
				<a href="login.jsp">
					<div id="h">
						<h1>member</h1>
					</div>
				</a>
			</div>
			<div class="col-md-6" id="hh" style="background-color: blue;">
				<a href="securitylogin.jsp">
					<div id="h">
						<h1>security</h1>
					</div>
				</a>
			</div>
		</div>
	</div>

</body>
</html>