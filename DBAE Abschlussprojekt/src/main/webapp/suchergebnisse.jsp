<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Suchergebnisse</title>
	
	<meta name="author" content="Clemens Beck">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="navigation.jsp" />
	
	<h1 class="suchergebnisse">Suchergebnisse</h1>
	<div class="table-responsive">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Titel</th>
					<th scope="col">Beschreibung</th>
					<th scope="col">Link</th>
				</tr>
			</thead>
			<tbody style="font-size: 12px;">
				<c:forEach var="produkt" items="${suchergebnisse}">
					<tr>
						<td><c:out value="${produkt.titel}" /></td>
						<td><c:out value="${produkt.beschreibung}" /></td>
						<td>
							<form class="products" method="GET" action=Produkte>
								<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}"> 
								<input class="btn btn-outline-info" type="submit" value="Details" name="" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> 
</body>
</html>