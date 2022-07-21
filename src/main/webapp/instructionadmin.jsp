<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visitor list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body style="background-color: grey;">
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row m-5 ">
			<div class="col-md-12"
				style="background-color: whitesmoke; padding: 30px; border-radius: 30px;">
				<table class="display" id="task">
					<thead class="thead-light">
						<tr>
							<th scope="col">No</th>
							<th scope="col">name</th>
							<th scope="col">type</th>
							<th scope="col">block no</th>
							<th scope="col">house_number</th>
							<th scope="col">exit time</th>
							<th scope="col">Date</th>
							<th scope="col">status</th>

						</tr>
					</thead>

					<tbody>
						<%
						int id = 1;
						%>
						<c:forEach items="${instruction}" var="it">
							<tr>
								<th scope="row"><%=id%></th>
								<td>${it.name}</td>
								<td>${it.type }</td>
								<td>${it.block_name}</td>
								<td>${it.house_number}</td>
								<td>${it.exit_time}</td>
								<td>${it.date}</td>
								<td>${it.status}</td>
								<%
								id++;
								%>

							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#task').DataTable();
		});
	</script>


</body>
</html>