<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrierung</title>
<link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>

	<form class="registrierung" method="POST"
		action="RegistrierungsServlet">
		<div class="container">
			<h1>Registrierung</h1>
			<p>Bitte fülle alle Spalten um die Registrierung abzuschließen</p>
			<hr>
			<h2>Nutzerdaten</h2>
			<label for="username"><b>Nutzername</b></label> <input type="text"
				placeholder="Nutzername" name="username" id="username" required>

			<label for="firstname"><b>Vorname</b></label> <input type="text"
				placeholder="Vorname" name="firstname" id="firstname"> <label
				for="lastname"><b>Nachname</b></label> <input type="text"
				placeholder="Vorname" name="lastname" id="lastname"> <label
				for="email"><b>Email</b></label> <input type="text"
				placeholder="Email adresse" name="email" id="email" required>

			<label for="psw"><b>Passwort</b></label> <input type="password"
				placeholder="Passwort" name="password" id="password" required>

			<label for="psw-repeat"><b>Wiederhole Passwort</b></label> <input
				type="password" placeholder="Wiederhole Passwort" name="psw-repeat"
				id="psw-repeat" required>
			<hr>
			<h2>Adresse</h2>
			<label for="street"><b>Straße</b></label> <input type="text"
				placeholder="Straße" name="street" id="street"> <label
				for="housenmb"><b>Hausnummer</b></label> <input type="number"
				placeholder="Hausnummer" name="housenmb" id="housenmb"> <br>
			<br> <label for="postalcode"><b>Postleitzahl</b></label> <input
				type="text" placeholder="Postleitzahl" name="postalcode"
				id="postalcode"> <label for="city"><b>Stadt</b></label> <input
				type="text" placeholder="Stadt" name="city" id="city">

			<p>
				Mit Erstellung des Accounts stimmst du allen <a href="#">Datenschutzbestimmungen</a>
				zu.
			</p>
			<button type="submit" class="registerbtn">Registrieren</button>
		</div>
	</form>
	<div class="container signin">
		<p>
			Du hast bereits einen Account? <br>
			<a href="login.jsp">Login</a>.
		</p>
	</div>

</body>
</html>