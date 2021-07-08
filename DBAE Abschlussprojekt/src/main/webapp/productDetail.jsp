<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${produkt.getTitel()} - Produktseite</title>
		<link rel="stylesheet" type="text/css" href="../css/productDetail.css">
	</head>
	<body>
		
		<p>${msg}</p>
		
		<div class="grid-container">
			<div class="titel">${produkt.getTitel()}</div>
			<div class="bild"><img src="${produkt.getBild()}" width="200em"></div>
			<div class="beschreibung">Beschreibung: ${produkt.getBeschreibung()}</div>
			<div class="preis">Preis: ${produkt.getPreis()}€</div>
			<div class="produktnummer">Produktnummer: ${produkt.getProduktnummer()}</div>
			<div class="type">Kategorie: ${produkt.getType()}</div>
		</div>
	</body>
</html>