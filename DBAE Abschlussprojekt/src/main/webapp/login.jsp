<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<form class="login" method="POST" action="LoginServlet">
		<div class="login">
			<h2>Login / Registrierung</h2>


			<input type="text" name="username" id="Uname" placeholder="Username">

			<input type="Password" name="password" id="Pass"
				placeholder="Password"> <br>
			<br>
			<div class="box bg-1">
				<button type="submit" name="login" value="Login!"
					class="button button--aylen button--round-l button--text-thick">Login</button>


				<form>
					<input class="regbtn" type="button" value="Registrierung"
						onclick="window.location.href='registrierung.jsp'" />
				</form>


				<br> <a href="#">Passwort vergessen</a> <br>
				<br> <input type="button" value="Zurück!" onclick="history.go(-1)">
	</form>

	</div>
</body>
</html>