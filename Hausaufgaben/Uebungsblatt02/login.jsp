<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/taglib/meineTaglibs.tld" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--Auflistung aller Autoren mit vollständigem Namen-->
	<meta name="authorOne" content="Dennis Hasselbusch">
	<meta name="authorThree" content="Clemens Beck">
	<meta name="authorTwo" content="Marten Kracke">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	</head>

<body>
	<div class ="container">
	<!-- Include unserer navigationbar.jsp um die Navigation anzuzeigen -->
	<jsp:include page="jsp/navigationbar.jsp"/>
	<h4>Bitte logge dich ein...</h4>

	<form method ="post" action ="Login">
		<div class="form-group">
			<label for="email">Email Adresse</label><br><input name="email"  type="email" class="form-controll" placeholder="Email adresse..." required ><br>
		</div>
		<div class ="form-group">
			<label for="passwort">Passwort</label><br> <input name="passwort" type="password" placeholder="Passwort..." required><br>
		</div>	
		<p class="text-danger">${error} </p>
		
		<button type="submit" class="btn btn-primary">Absenden</button>
		
		
	</form>




</div>
</body>
</html>