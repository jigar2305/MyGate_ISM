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
<title>houses</title>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>

	<div class="container">

		<table class="table mt-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No.</th>
					<th scope="col">block no</th>
					<th scope="col">house_number</th>
					<th scope="col">ststus</th>
					<th scope="col">add member</th>

				</tr>
			</thead>
			<tbody>
				<%
				int id = 1;
				%>
				<c:forEach items="${houses}" var="it">
					<tr style="hight: 10px;">
						<th scope="row"><%=id%></th>
						<td>${it.block_name}</td>
						<td>${it.house_number}</td>
						<td>${it.status}</td>
						<td><a href="AddmemberBuyhouseController?houseid=${it.houseid}"> add member</a></td>
						<%
						id++;
						%>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>