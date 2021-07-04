<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Aufgabe 3</title>
</head>
<body>

<div class="p-3 mb-2 bg-info text-white">
	<div class="d-flex justify-content-around">
		<div class="p-2 bd-highlight"><a href="index.jsp">Home</a></div>
		<div class="p-2 bd-highlight">296232, Dennis Hasselbusch</div>
		<div class="p-2 bd-highlight">296482, Marten Kracke</div>
		<div class="p-2 bd-highlight">301303, Clemens Beck</div>
	</div>
</div>


<div class="container">
	<div class="d-flex justify-content-center">
		
		<p style="color:red;"><br> ${ message }</p>
	</div>
	
	
	
	<div class="d-flex justify-content-center">

		<form action="MyServlet" method="post">
			<input type="email" id="email" name="email" placeholder="Email"><br>
			<input type="password" id="password" name="password" placeholder="Passwort"><br>
			<input type="radio" name="type" value="admin"> Administrator <br>
			<input type="radio" name="type" value="user"> Benutzer <br>
			<button type="submit" value="submit">Absenden!</button>
			
		</form>
	</div>
</div>
	


</body>
</html> 