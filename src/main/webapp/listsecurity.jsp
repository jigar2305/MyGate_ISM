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
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container"></div>
	<div class="row">
		<div class="col-md-2"></div>

		<div class="col-md-8">
			<div>${msg}</div>
			<table class="table mt-5">
				<thead class="thead-dark">
					<tr>
						<th scope="col">firstname</th>
						<th scope="col">lastname</th>
						<th scope="col">contact_number</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${instruction}" var="it">
					<c:if test="${(it.status =='allow')}">
						<tr style="hight: 10px;">
							<td>${it.firstname}</td>
							<td>${it.lastname}</td>
							<td>${it.contact_number}</td>
						
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>

</body>
</html>