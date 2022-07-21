<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>dashbord</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<div>${msg}</div>
		<table class="table mt-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No.</th>
					<th scope="col">firstname</th>
					<th scope="col">lastname</th>
					<th scope="col">emailid</th>
					<th scope="col">role</th>
					<th scope="col">status</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>
				<%
				int id = 1;
				%>
				<c:forEach items="${users}" var="it">
					<tr style="hight: 10px;">
						<th scope="row"><%=id%></th>
						<td>${it.firstname}</td>
						<td>${it.lastname}</td>
						<td>${it.email}</td>
						<td>${it.role}</td>
						<td>${it.active}</td>
						<%
						id++;
						%>
						<td><a href="ActiveUserController?userid=${it.userid}&active=${it.active}"
							class="btn btn-success">
							<c:if test="${(it.active == 'active')}">
							Deactivate</c:if>
							<c:if test="${(it.active == 'deactive')}">
							activate</c:if>
							
							</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>