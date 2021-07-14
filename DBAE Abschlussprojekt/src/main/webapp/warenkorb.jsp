<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Warenkorb</title>
	
		<!--Viewport auf Basis des verw. Geräts mit Skalierung 10-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/warenkorb.css">
	</head>
	<body>
		<jsp:include page="navigation.jsp" />
		<form class="bestellung" method="POST" action="BestellungServlet">
			<div class="grid-container">
				<table class="produkte table table-hover table-striped ">
					<thead>
						<tr>
							<th scope="col">Artikel</th>
							<th scope="col"></th>
							<th scope="col">Summe</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produkt" items="${produkte}">
							<tr>
								<td><img src="${produkt.bild}" width="100em"></td>
								<td><c:out value="${produkt.titel}" /></td>
								<td><c:out value="${produkt.preis} EUR" /></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td>
							Gesamtbetrag:<br>
							Gesamtbetrag ohne MwSt.:<br>
							zzgl. 19% MwSt.:
							</td>
							<td>
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${gesamtbetrag * 1.19}"/><br>
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${gesamtbetrag}"/><br>
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${gesamtbetrag / 100 * 19}"/>
							</td>
						</tr>
					</tbody>
				</table>
		
				<p class="adresse">Adresse</p>
			
				<input class="strasse form-control" type="text" id="strasse" name="strasse" value="${benutzer.getStreet()}" placeholder="Strasse" required>
				<input class="hausnummer form-control" type="text" id="hausnummer" name="hausnummer" value="${benutzer.getHousenmb()}" placeholder="Hausnummer" required>
				<input class="postleitzahl form-control" type="text"id="postleitzahl" name="postleitzahl" value="${benutzer.getPostalcode()}" placeholder="Postleitzahl" required>
				<input class="stadt form-control" type="text" id="stadt" name="stadt" value="${benutzer.getCity()}" placeholder="Stadt" required>
				
				<p class="agb">Mit der Bestellung stimme ich den AGB und Datenschutzbestimmungen zu.</p>
				
				<input class="bestellen btn btn-primary" type="submit" value="Zahlungspflichtig bestellen" class="checkout_btn">
				<button class="abbrechen btn btn-outline-secondary" type="button" onclick="history.go(-1)">Abbrechen</button>
		
			</div>
		</form>
	
		
	</body>
</html>