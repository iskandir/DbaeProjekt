<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--Auflistung aller Autoren mit vollständigem Namen-->
	<meta name="authorOne" content="Dennis Hasselbusch">
	<meta name="authorThree" content="Clemens Beck">
	<meta name="authorTwo" content="Marten Kracke">
	<title>Registrierung</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	</head>


<body>
	<div class ="container">
	<!-- Include unserer navigationbar.jsp um die Navigation anzuzeigen -->
	<jsp:include page="jsp/navigationbar.jsp"/>
	<h4>Bitte registriere dich vor der Nutzung.</h4>
	<!-- Formular zur Registierung -->
	<form method ="post" action ="Registrierung">
		<div class="form-group">
			<label for="email">Email Adresse</label><br><input name="email"  type="email" class="form-controll" placeholder="Email adresse..." required><br>
		</div>
		<div class="form-group">
			<label for="vorname">Vorname</label><br><input name="vorname" placeholder="Vorname" type="text"><br>
		</div>
		<div class="form-group">
			<label for="nachname">Nachname</label><br><input name="nachname" placeholder="Nachname" type="text"><br>
		</div>
		<div class="form-group">
			<label for="alter">Alter</label><input name="alter" min= 0 max = 99 type="number" placeholder= "Alter" placeholder= 1><br>
		</div>
		<!-- Registrierung über Checkbox -->
		<div class="form-group">
			<h5>Rolle</h5>
			<input class="messageCheckbox" type="checkbox" name= "rolle" value="Gast"><label for="rolle">Gast</label><br>
			<input class="messageCheckbox" type="checkbox" name= "rolle" value="Benutzer"><label for="rolle">Benutzer</label><br>
			<input class="messageCheckbox" type="checkbox" name= "rolle" value="Administrator"><label for="rolle">Administrator</label><br>
		</div>
		<div class ="form-group">
			<label for="passwort">Passwort</label><br> <input name="passwort" type="password" placeholder="Passwort" required><br>
		</div>
		<div class ="form-group">
			<label for="passwort">Passwort(Wiederholen)</label><br> <input name="passwortWdh" placeholder="Wiederhole Passwort" type="password" required><br>
		</div>
		<p class="text-danger">${error} </p>
		<button type="submit" class="btn btn-primary">Absenden</button>
		
	</form>
</div>
</body>
</html>