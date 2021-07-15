<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>supportForm</title>
<link rel="stylesheet" type="text/css" href="css/support.css">
</head>
<body>

	<jsp:include page="navigation.jsp"/>
 
	<form class="" method="POST" action="SupportServlet">
		<div class="grid-container">
			<p class="supportticket">Support Ticket erstellen</p>
			<input class="vorname form-control" type="text" name="vorname" id="vorname" placeholder="Vorname" required>
			<input class="nachname form-control" type="text" name="nachname" id="nachname" placeholder="Nachname" required>
			<input class="email form-control" type="email" name="email" id="email" placeholder="Email" required>
			<input class="betreff form-control" type="text" name="betreff" id="betreff" placeholder="Betreff" required>
			
			<textarea class="inhalt form-control" id="inhalt" name="inhalt" rows="" cols="" maxlength="1500"></textarea> 
			
			<input class="abschicken btn btn-primary" type="submit" name="abschicken" value="Abschicken">
			<button class="abbrechen btn btn-outline-secondary" type="button" onclick="history.go(-1)">Abbrechen</button>
		</div>
	</form>
		
   
</body>
</html>




