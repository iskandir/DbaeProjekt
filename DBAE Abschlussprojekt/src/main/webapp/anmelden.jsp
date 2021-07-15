<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="author" content="Dennis Hasselbusch">
<link rel="stylesheet" type="text/css" href="css/anmelden.css">
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<form class="" method="POST" action=AnmeldenServlet>
		<div class="grid-container">

			<input class="benutzername form-control" type="text" name="benutzername" id="benutzername" placeholder="Benutzername" required>
			<input class="passwort form-control" type="password" name="passwort" id="passwort" placeholder="Passwort" required>
			<input class="anmelden btn btn-primary" type="submit" name="anmelden" value="Anmelden">
			
			<p class="fehlermeldung">${error}</p>

			<button class="registrieren btn btn-outline-secondary" type="button" onclick="window.location.href='registrieren.jsp'">Registrieren</button>
			<button class="abbrechen btn btn-outline-secondary" type="button" onclick="history.go(-1)">Abbrechen</button>

		</div>
	</form>
</body>
</html>
