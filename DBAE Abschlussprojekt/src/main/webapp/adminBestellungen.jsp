<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Administration - Bestellungen</title>
	
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
						<th scope="col">Bestellnummer</th>
						<th scope="col">Bestellzeitpunkt</th>
						<th scope="col">Produkte</th>
						<th scope="col">Gesamtbetrag</th>
						<th scope="col">Vorname</th>
						<th scope="col">Nachname</th>
						<th scope="col">Strasse</th>
						<th scope="col">Nr.</th>
						<th scope="col">PLZ.</th>
						<th scope="col">Stadt</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="bestellung" items="${bestellungenListe}">
						<tr>
							<td><c:out value="${bestellung.bestellnummer}" /></td>
							<td><c:out value="${bestellung.bestellzeitpunkt}" /></td>

							<td><c:forEach var="produktnummer"
									items="${bestellung.produktnummern}">
									<form class="products" method="GET" action=Produkte>
										<input type="hidden" id="custId" name="p" value="${produktnummer}"> 
										<input class="btn btn-outline-info" type="submit" value="${produktnummer}" name="" />
									</form>
									<br>
								</c:forEach></td>

							<td><c:out value="${bestellung.gesamtbetrag}" /></td>
							<td><c:out value="${bestellung.vorname}" /></td>
							<td><c:out value="${bestellung.nachname}" /></td>
							<td><c:out value="${bestellung.strasse}" /></td>
							<td><c:out value="${bestellung.hausnummer}" /></td>
							<td><c:out value="${bestellung.postleitzahl}" /></td>
							<td><c:out value="${bestellung.stadt}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>