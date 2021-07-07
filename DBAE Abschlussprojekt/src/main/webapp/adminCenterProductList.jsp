<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Center Produkte</title>
	</head>
	<body>
	
		<jsp:include page="navBar.jsp"/>
			
		
		<div class="container"> 
			<table class="table table-sm table-striped">
	            <thead>
		            <tr>
		                <th scope="col">Titel</th>
		                <th scope="col">Beschreibung</th>
		                <th scope="col">Preis (EUR)</th>
		                <th scope="col">Bild</th>
		                <th scope="col">Produktnummer</th>
		                <th scope="col">Typ</th>
		            </tr>
	            </thead>
	            <tbody style="font-size: 10px;">
	            	<c:forEach var="produkt" items="${hardwareListe}">
		                <tr>
		                    <td><c:out value="${produkt.titel}" /></td>
		                    <td><c:out value="${produkt.beschreibung}" /></td>
		                    <td><c:out value="${produkt.preis}" /></td>
		                    <td><a href="${produkt.bild}" target=”_blank”>Bild</a></td>
		                    <td><c:out value="${produkt.produktnummer}" /></td>
		                    <td><c:out value="${produkt.type}" /></td>
		                    
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
	        <table class="table table-sm table-striped">
	            <thead>
		            <tr>
		                <th scope="col">Titel</th>
		                <th scope="col">Beschreibung</th>
		                <th scope="col">Preis (EUR)</th>
		                <th scope="col">Bild</th>
		                <th scope="col">Produktnummer</th>
		                <th scope="col">Typ</th>
		            </tr>
	            </thead>
	            <tbody style="font-size: 10px;">
	            	<c:forEach var="produkt" items="${softwareListe}">
		                <tr>
		                    <td><c:out value="${produkt.titel}" /></td>
		                    <td><c:out value="${produkt.beschreibung}" /></td>
		                    <td><c:out value="${produkt.preis}" /></td>
		                    <td><a href="${produkt.bild}" target=”_blank”>Bild</a></td>
		                    <td><c:out value="${produkt.produktnummer}" /></td>
		                    <td><c:out value="${produkt.type}" /></td>
		                    
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
	        <table class="table table-sm table-striped">
	            <thead>
		            <tr>
		                <th scope="col">Titel</th>
		                <th scope="col">Beschreibung</th>
		                <th scope="col">Preis (EUR)</th>
		                <th scope="col">Bild</th>
		                <th scope="col">Produktnummer</th>
		                <th scope="col">Typ</th>
		            </tr>
	            </thead>
	            <tbody style="font-size: 10px;">
	            	<c:forEach var="produkt" items="${peripherieListe}">
		                <tr>
		                    <td><c:out value="${produkt.titel}" /></td>
		                    <td><c:out value="${produkt.beschreibung}" /></td>
		                    <td><c:out value="${produkt.preis}" /></td>
		                    <td><a href="${produkt.bild}" target=”_blank”>Bild</a></td>
		                    <td><c:out value="${produkt.produktnummer}" /></td>
		                    <td><c:out value="${produkt.type}" /></td>
		                    
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
		</div>
	</body>
</html>