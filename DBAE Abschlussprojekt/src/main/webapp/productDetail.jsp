<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${produkt.getTitel()} - Produktseite</title>
		<link rel="stylesheet" type="text/css" href="css/productDetail.css">
	</head>
	<body>
	
		<jsp:include page="navBar.jsp"/>
		
		<p id="error">${msg}</p>
		
		<c:if test="${not empty produkt}">
			<div class="grid-container">
				<div class="titel">${produkt.getTitel()}</div>
				<div class="bild"><img src="${produkt.getBild()}" width="200em"></div>
				<div class="beschreibung">Beschreibung: ${produkt.getBeschreibung()}</div>
				<div class="preis">Preis: ${produkt.getPreis()}€</div>
				<div class="produktnummer">Produktnummer: ${produkt.getProduktnummer()}</div>
				<div class="type">Kategorie: ${produkt.getType()}</div>
			</div>
			<div class="container">
				<form class ="products" method="POST" action=WarenkorbServlet>
				 	<input type="text" id="produktnummer" name="produktnummer" value="${produkt.getProduktnummer()}">
					<input type="submit" value="Zu Warenkorb hinzufuegen" name=""/>
				</form>
			</div>
		</c:if>
	</body>
</html>