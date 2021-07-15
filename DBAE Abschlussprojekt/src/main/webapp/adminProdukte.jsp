<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Administration - Produkte</title>

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
						<th scope="col">Titel</th>
						<th scope="col">Beschreibung</th>
						<th scope="col">Preis</th>
						<th scope="col">Bild</th>
						<th scope="col">ProduktNr</th>
						<th scope="col">Typ</th>
						<th scope="col">Table</th>
						<th scope="col">Detail</th>
						<th scope="col">Kaufanzahl</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="produkt" items="${hardwareListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td>
								<form action="${produkt.bild}">
									<input class="btn btn-outline-info" type="submit" value="Bild" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
							<td>
								<form class="products" method="GET" action=DetailServlet>
									<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}"> 
									<input class="btn btn-outline-info" type="submit" value="Details" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.kaufanzahl}" /></td>
						</tr>
					</c:forEach>
					<c:forEach var="produkt" items="${softwareListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td>
								<form action="${produkt.bild}">
									<input class="btn btn-outline-info" type="submit" value="Bild" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
							<td>
								<form class="products" method="GET" action=DetailServlet>
									<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}"> 
									<input class="btn btn-outline-info" type="submit" value="Details" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.kaufanzahl}" /></td>
						</tr>
					</c:forEach>
					<c:forEach var="produkt" items="${peripherieListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td>
								<form action="${produkt.bild}">
									<input class="btn btn-outline-info" type="submit" value="Bild" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
							<td>
								<form class="products" method="GET" action=DetailServlet>
									<input type="hidden" id="custId" name="p"
										value="${produkt.produktnummer}"> 
										<input class="btn btn-outline-info" type="submit" value="Details" name="" />
								</form>
							</td>
							<td><c:out value="${produkt.kaufanzahl}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>