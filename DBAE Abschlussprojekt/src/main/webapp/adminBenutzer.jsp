<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administration - Benutzer</title>
	</head>
	<body>
	
		<jsp:include page="navBar.jsp"/>
		
		<div class="container">
	        
	        <table class="table table-sm table-striped">
	            <thead>
		            <tr>
                		<th scope="col">Username</th>
		                <th scope="col">Nachname</th>
		                <th scope="col">Vorname</th>
		                <th scope="col">Email</th>
		                <th scope="col">Strasse</th>
		                <th scope="col">HausNr</th>
		                <th scope="col">PLZ</th>
		                <th scope="col">Stadt</th>
		            </tr>
	            </thead>
	            <tbody style="font-size: 12px;">
	            	<c:forEach var="benutzer" items="${benutzerliste}">
		                <tr>
		                    <td><c:out value="${benutzer.username}" /></td>
		                    <td><c:out value="${benutzer.lastName}" /></td>
		                    <td><c:out value="${benutzer.firstName}" /></td>
		                    <td><c:out value="${benutzer.email}" /></td>
		                    <td><c:out value="${benutzer.street}" /></td>
		                    <td><c:out value="${benutzer.housenmb}" /></td>
		                    <td><c:out value="${benutzer.postalcode}" /></td>
		                    <td><c:out value="${benutzer.city}" /></td>
		                    
		                </tr>
	            	</c:forEach>
	            </tbody>
	        </table>
		</div>
	</body>
</html>