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
	
	<div class="container">

		<form class="registrierung" method="POST" action="RegistrierungsServlet">
		<!-- TODO: Prüfen ob ALLE inputs required waren!! -->
			<h1>Registrierung</h1>
			<hr>
			<h2>Nutzerdaten</h2>
			<label for="username"> <b>Nutzername</b> </label> 
			<input type="text" placeholder="Nutzername" name="username" id="username" required>
		
			<label for="firstname"> <b>Vorname</b> </label> 
			<input type="text" placeholder="Vorname" name="firstname" id="firstname" required> 
			
			<label for="lastname"> <b>Nachname</b> </label> 
			<input type="text" placeholder="Vorname" name="lastname" id="lastname" required> 
			
			<label for="email"> <b>Email</b> </label> 
			<input type="email" placeholder="Email adresse" name="email" id="email" required>
		
			<label for="password"> <b>Passwort</b> </label> 
			<input type="password" placeholder="Passwort" name="password" id="password" required>
		
			<label for="psw-repeat"> <b>Wiederhole Passwort</b> </label>
			<input type="password" placeholder="Wiederhole Passwort" name="psw-repeat" id="psw-repeat" required>
			
			<hr>
			<h2>Adresse</h2>
			
			<label for="street"><b>Straße</b></label>
			<input type="text" placeholder="Straße" name="street" id="street" required>
			
			<label for="housenmb"><b>Hausnummer</b></label>
			<input type="number" placeholder="Hausnummer" name="housenmb" id="housenmb" required> <br>
			
			<br> <label for="postalcode"><b>Postleitzahl</b></label>
			<input type="text" placeholder="Postleitzahl" name="postalcode" id="postalcode" required>
			
			<label for="city"><b>Stadt</b></label>
			<input type="text" placeholder="Stadt" name="city" id="city" required>
			<p>
				Mit Erstellung des Accounts stimmst du allen <a href="#">Datenschutzbestimmungen</a>
				zu.
			</p>
			<button type="submit" class="registerbtn">Registrieren</button>
		
		</form>
	
	</div>
	
	<div class="container signin">
		<p>
			Du hast bereits einen Account? <br>
			<a href="login.jsp">Login</a>.
		</p>
	</div>

</body>
</html>