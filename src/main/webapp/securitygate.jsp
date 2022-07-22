<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	<jsp:include page="navsecurity.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row ml-2 mr-2">

			<div class="col-md-4 pt-3 pb-3 mt-5"
				style="border: 1px solid black; border-radius: 20px; background-color: white;">

				<form action="AddinstructionController" method="post">

					<div style="text-align: center;">
						<h1 style="font-size: 30px;">Add</h1>
					</div>
					<div style="text-align: center;">
						<h1 style="font-size: 30px;">${msg}</h1>
					</div>
					<div class="form-group">
						<input type="text" placeholder="name" name="name"
							class="form-control" value="${namevalue}" />${nameError}
					</div>
					<div class="form-group">
						<input type="text" placeholder="type" name="type"
							class="form-control" value="${typevalue}" />${typeError}
					</div>
					<div class="form-group">
						<input type="text" placeholder="description" name="description"
							class="form-control" value="${descriptionvalue}" />${descriptionError}
					</div>

					<div class="form-group">
						<input type="time" placeholder="Exittime" class="form-control"
							name="exit_time" />
					</div>
					<label for="block">Select block:</label> <select id="block"
						name="block_number">
						<c:forEach items="${houses}" var="it">
							<option value="${it.houseid}">${it.block_name}</option>
						</c:forEach>
						<c:set var="blockname" value="${it.block_name}"></c:set>
					</select> <br> <label for="cars">Select house:</label> <select
						id="cars" name="house_number">
						<c:forEach items="${houses}" var="it">
							<%-- 						<c:if test="${(it.block_name == house_number)}">
 --%>
							<option value="${it.houseid}">${it.house_number}</option>
							<%-- 						</c:if> 
 --%>
						</c:forEach>
					</select> ${FlateError} <br> <br>
					<div style="text-align: center;">
						<input type="submit" value="submit" class="btn btn-primary" />
					</div>

				</form>


			</div>
			<div class="col-md-8">

				<table class="table mt-5 ">
					<thead class="thead-dark ">
						<tr>
							<th scope="col">name</th>
							<th scope="col">type</th>
							<th scope="col">block no</th>
							<th scope="col">house_number</th>
							<th scope="col">exit time</th>
							<th scope="col">exit</th>

							<th scope="col">status</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${instruction}" var="it">
							<c:if test="${it.status=='Not allow'}">
								<tr style="hight: 8px;">
									<td>${it.name}</td>
									<td>${it.type }</td>
									<td>${it.block_name}</td>
									<td>${it.house_number}</td>
									<td>${it.exit_time}</td>
									<td style="background-color: orange; border-radius: 10px; text-align: center; color: white; margin-right: 2px;"><a
										href="ExitetimeController?instructionid=${it.instructionid}" class="btn">Exit</a></td>

									<td
										style="background-color: red; border-radius: 10px; text-align: center; color: white;">${it.status}
									</td>
								</tr>
							</c:if>
						</c:forEach>
						<c:forEach items="${instruction}" var="it">
							<c:if test="${it.status=='allow'}">
								<tr style="hight: 10px;">
									<td>${it.name}</td>
									<td>${it.type }</td>
									<td>${it.block_name}</td>
									<td>${it.house_number}</td>
									<td>${it.exit_time}</td>
									<td style="background-color: orange; border-radius: 10px; text-align: center; color: white; margin-right: 2px;"><a
										href="ExitetimeController?instructionid=${it.instructionid}" class="btn">Exit</a></td>

									<td
										style="background-color: green; border-radius: 10px; text-align: center; color: white;">${it.status}
									</td>

								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>

</html>