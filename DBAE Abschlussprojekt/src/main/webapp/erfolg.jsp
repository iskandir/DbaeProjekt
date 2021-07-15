<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Support</title>
		<link rel="stylesheet" type="text/css" href="css/erfolg.css">
	</head>
	<body>
		<jsp:include page="navigation.jsp"/>
		
		
		<div class="grid-container">
			<p class="output">${output}</p>
			
			<button class="registrieren btn btn-primary" type="button" onclick="window.location.href='index.jsp'">Zur Startseite</button>
		</div>
	</body>
</html>