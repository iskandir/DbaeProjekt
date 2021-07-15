<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${produkt.getTitel()} - Produktseite</title>
		
		<link rel="stylesheet" type="text/css" href="css/detail.css">
	</head>
	<body>
	
		<jsp:include page="navigation.jsp"/>
		
		<p id="error">${msg}</p>
		
		<c:if test="${not empty produkt}">
			<div class="grid-container">
				<div class="titel">${produkt.getTitel()}</div>
				<div class="bild"><img src="${produkt.getBild()}" width="400em"></div>
				<div class="beschreibung">Beschreibung: ${produkt.getBeschreibung()}</div>
				<div class="preis">Preis: ${produkt.getPreis()}€</div>
				<div class="produktnummer">Produktnummer: ${produkt.getProduktnummer()}</div>
				<div class="type">Kategorie: ${produkt.getType()}</div>
			
				<form class ="products" method="GET" action=WarenkorbServlet>
				 	<input type="hidden" id="produktnummer" name="produktnummer" value="${produkt.getProduktnummer()}">
					<input class="warenkorb btn btn-primary" type="submit" value="Zu Warenkorb hinzufuegen" name=""/>
				</form>
			</div>
		</c:if>
	</body>
</html>