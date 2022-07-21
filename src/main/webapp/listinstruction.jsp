<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>
</head>
<body>
	<jsp:include page="navcustomer.jsp"></jsp:include>
	<div class="container"></div>
	<div class="row">
		<div class="col-md-2"></div>

		<div class="col-md-8">
			<div>${msg}</div>
			<table class="table mt-5">
				<thead class="thead-dark">
					<tr>
						<th scope="col">name</th>
						<th scope="col">type</th>
						<th scope="col">block no</th>
						<th scope="col">house_number</th>
						<th scope="col">exit time</th>
						<th scope="col">status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${instruction}" var="it">
					<c:if test="${(it.status =='allow')}">
						<tr style="hight: 10px;">
							<td>${it.name}</td>
							<td>${it.type }</td>
							<td>${it.block_name}</td>
							<td>${it.house_number}</td>
							<td>${it.exit_time}</td>
							<td>${it.status}</td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>

</body>
</html>