<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<meta name="author" content="Dennis Hasselbusch">
</head>
<body>

<form class="login" method="GET" action="LogoutServlet">
<button type="submit" name="logout" value="Logout!"
class="button button--aylen button--round-l button--text-thick">Ausloggen</button>
				
				<br> <input type="button" value="Zurück!"
					onclick="history.go(-1)">
</form>
</body>
</html>