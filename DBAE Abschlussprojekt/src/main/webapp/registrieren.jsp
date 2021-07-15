<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Registrierung</title>
	
	<meta name="author" content="Dennis Hasselbusch">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/registrieren.css">
</head>
<body>
	<jsp:include page="navigation.jsp" />

	<form class="" method="POST" action=RegistrierenServlet>
		<div class="grid-container">
			<p class="benutzerdaten">Benutzer-Daten</p>
			<input class="benutzername form-control" type="text" name="benutzername" id="benutzername" placeholder="Benutzername" required>
			<input class="vorname form-control" type="text" name="vorname" id="vorname" placeholder="Vorname" required>
			<input class="nachname form-control" type="text" name="nachname" id="nachname" placeholder="Nachname" required>
			<input class="email form-control" type="email" name="email" id="email" placeholder="Email" required>
			<input class="passwort form-control" type="password" name="passwort" id="passwort" placeholder="Passwort" required>
			<input class="passwort-repeat form-control" type="password" name="passwort-repeat" id="passwort-repeat" placeholder="Passwort wiederholen" required>
		
			<p class="anschrift">Anschrift</p>
			<input class="strasse form-control" type="text" name="strasse" id="strasse" placeholder="Strasse">
			<input class="hausnummer form-control" type="text" name="hausnummer" id="hausnummer" placeholder="Hausnummer">
			<input class="postleitzahl form-control" type="text" name="postleitzahl" id="postleitzahl" placeholder="Postleitzahl">
			<input class="stadt form-control" type="text" name="stadt" id="stadt" placeholder="Stadt">
			
			<p class="agb">Mit der Erstellung eines Accounts stimme ich den AGB und Datenschutzbestimmungen zu.</p>
			<input class="registrieren btn btn-primary" type="submit" name="registrieren" value="Registrieren"> 
			
			<p class="fehlermeldung">${error}</p>
			
			<button class="anmelden btn btn-outline-secondary" type="button" onclick="window.location.href='anmelden.jsp'">Anmelden</button>
			<button class="abbrechen btn btn-outline-secondary" type="button" onclick="history.go(-1)">Abbrechen</button>
			
			
		</div>
	</form>
</body>
</html>