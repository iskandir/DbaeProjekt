<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration - Produkte</title>
</head>
<body>

	<jsp:include page="navigation.jsp" />


	<div class="container-fluid">
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col" style="width: 15%">Titel</th>
						<th scope="col" style="width: 20%">Beschreibung</th>
						<th scope="col" style="width: 10%">Preis</th>
						<th scope="col" style="width: 5%">Bild</th>
						<th scope="col" style="width: 10%">ProduktNr</th>
						<th scope="col" style="width: 10%">Typ</th>
						<th scope="col" style="width: 10%">Table</th>
						<th scope="col" style="width: 10%">Detail</th>
						<th scope="col" style="width: 10%">Kaufanzahl</th>
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
									<input class="btn btn-outline-info" type="submit" value="Detail" name="" />
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
									<input class="btn btn-outline-info" type="submit" value="Detail" name="" />
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
										<input class="btn btn-outline-info" type="submit" value="Detail" name="" />
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