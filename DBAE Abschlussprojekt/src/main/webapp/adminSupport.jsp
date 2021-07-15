<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Administration - Support</title>
	
	<meta name="author" content="Clemens Beck">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="navigation.jsp" />

	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">Nr.</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Betreff</th>
						<th scope="col">Inhalt</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="ticket" items="${ticketliste}">
						<tr>
							<td><c:out value="${ticket.id}" /></td>
							<td><c:out value="${ticket.name}, ${ticket.vorname}" /></td>
							<td><c:out value="${ticket.betreff}" /></td>
							<td><c:out value="${ticket.mail}" /></td>
							<td><c:out value="${ticket.inhalt}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>