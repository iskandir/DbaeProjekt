<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
<head>
	<title>Administration</title>
	
	<meta name="author" content="Clemens Beck">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="grid-container">
		<div class="card produkte" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Produkte</h5>
		    <p class="card-text">Hier siehst du alle Produkte in den Datenbanken Hardware, Software, Peripherie.</p>
		    <form class="" method="POST" action=AdminServlet>
				<input class="btn btn-primary" type="submit" value="Produkte" name="details" />
			</form>
		  </div>
		</div>
		<div class="card betellungen" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Bestellungen</h5>
		    <p class="card-text">Hier siehst du alle Bestellungen.</p>
		    <form class="" method="POST" action=AdminServlet>
				<input class="btn btn-primary" type="submit" value="Bestellungen" name="details" />
			</form>
		  </div>
		</div>
		<div class="card kunden" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Kunden</h5>
		    <p class="card-text">Hier siehst du alle Kunden, die sich bisher angemeldet haben.</p>
		    <form class="" method="POST" action=AdminServlet>
				<input class="btn btn-primary" type="submit" value="Kunden" name="details" />
			</form>
		  </div>
		</div>
		<div class="card support" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Supporttickets</h5>
		    <p class="card-text">Hier siehst du alle Supporttickets.</p>
		    <form class="" method="POST" action=AdminServlet>
				<input class="btn btn-primary" type="submit" value="Support" name="details" />
			</form>
		  </div>
		</div>
	</div>
</body>
</html>