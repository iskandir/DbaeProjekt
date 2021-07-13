<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administration - Produkte</title>
	</head>
	<body>
	
		<jsp:include page="navBar.jsp"/>
			
		
		<div class="container">
			<table class="table table-sm table-striped">
				<thead>
					<tr>
						<th scope="col" style="width: 25%">Titel</th>
						<th scope="col" style="width: 20%">Beschreibung</th>
						<th scope="col" style="width: 10%">Preis</th>
						<th scope="col" style="width: 5%">Bild</th>
						<th scope="col" style="width: 10%">ProduktNr</th>
						<th scope="col" style="width: 10%">Typ</th>
						<th scope="col" style="width: 10%">Table</th>
						<th scope="col" style="width: 10%">Detail</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="produkt" items="${hardwareListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td><a href="${produkt.bild}" target="_blank"€>Bild</a></td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
	
							<td> 
								<form class ="products" method="GET" action=Produkte>
								 	<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}">
									<input type="submit" value="Link" name=""/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table table-sm table-striped">
				<thead>
					<tr>
						<th scope="col" style="width: 25%">Titel</th>
						<th scope="col" style="width: 20%">Beschreibung</th>
						<th scope="col" style="width: 10%">Preis</th>
						<th scope="col" style="width: 5%">Bild</th>
						<th scope="col" style="width: 10%">ProduktNr</th>
						<th scope="col" style="width: 10%">Typ</th>
						<th scope="col" style="width: 10%">Table</th>
						<th scope="col" style="width: 10%">Detail</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="produkt" items="${softwareListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td><a href="${produkt.bild}" target="_blank"€>Bild</a></td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
	
							<td> 
								<form class ="products" method="GET" action=Produkte>
								 	<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}">
									<input type="submit" value="Link" name=""/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table table-sm table-striped">
				<thead>
					<tr>
						<th scope="col" style="width: 25%">Titel</th>
						<th scope="col" style="width: 20%">Beschreibung</th>
						<th scope="col" style="width: 10%">Preis</th>
						<th scope="col" style="width: 5%">Bild</th>
						<th scope="col" style="width: 10%">ProduktNr</th>
						<th scope="col" style="width: 10%">Typ</th>
						<th scope="col" style="width: 10%">Table</th>
						<th scope="col" style="width: 10%">Detail</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="produkt" items="${peripherieListe}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td><c:out value="${produkt.preis} EUR" /></td>
							<td><a href="${produkt.bild}" target="_blank"€>Bild</a></td>
							<td><c:out value="${produkt.produktnummer}" /></td>
							<td><c:out value="${produkt.type}" /></td>
							<td><c:out value="${produkt.art}" /></td>
	
							<td> 
								<form class ="products" method="GET" action=Produkte>
								 	<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}">
									<input type="submit" value="Link" name=""/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>