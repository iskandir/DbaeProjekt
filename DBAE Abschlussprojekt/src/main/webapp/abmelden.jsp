<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Abmelden</title>

	<meta name="author" content="Dennis Hasselbusch">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/abmelden.css">
</head>
<body>
	<jsp:include page="navigation.jsp" />
	
	<form class="login" method="GET" action=AbmeldenServlet>
		<div class="grid-container">
			<input class="abmelden btn btn-primary" type="submit" name="abmelden" value="Abmelden">
			<button class="abbrechen btn btn-outline-secondary" type="button" onclick="history.go(-1)">Abbrechen</button>
		</div>
	</form>
</body>
</html>