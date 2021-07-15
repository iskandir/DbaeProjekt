<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Abmelden</title>
<meta name="author" content="Dennis Hasselbusch">
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