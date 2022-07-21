<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add member</title>
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
	<%
	String genderError = (String) request.getAttribute("genderError");

	String gendervalue = (String) request.getAttribute("gendervalue");
	%>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 pt-3 pb-3"
				style="border: 1px solid black; border-radius: 20px; background-color: white;">

				<form action="AddmemberController" method="post">

					<div style="text-align: center;">
						<h1 style="font-size: 30px;">add member</h1>
					</div>
					<div style="text-align: center;">
					<h1 style="font-size: 30px;">${msg}</h1>
				</div>
				<input type="text"  name="houseid"
							 value="${houseid}" hidden="true"/>
					<div class="form-group">
						<input type="text" placeholder="firstname" name="firstname"
							class="form-control" value="${firstnamevalue}" />${firstnameError}
					</div>

					<div class="form-group">
						<input type="number" placeholder="age" class="form-control"
							name="age" value="${agevalue}" />${ageError}
					</div>
					<div class="form-group">
						<input type="tel" placeholder="contect number"
							class="form-control" name="contact_number" value="${numbervalue}" />${numberError}
					</div>
					<div class="form-check">
						male:<input type="radio" value="male" name="gender"
							<%=gendervalue != null && gendervalue.equals("male") ? "checked" : ""%> />
						female:<input type="radio" value="female" name="gender"
							<%=gendervalue != null && gendervalue.equals("female") ? "checked" : ""%> />
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