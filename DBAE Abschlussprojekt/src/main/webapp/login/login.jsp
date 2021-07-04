<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="login.css">  
</head>
<body>    
    <h2>Login</h2><br>    
    <div class="login">    
    <form id="login" method="get" action="login.php">    
        <label><b>Benutzername   
        </b>    
        </label>    
        <input type="text" name="Uname" id="Uname" placeholder="Username">    
        <br><br>    
        <label><b>Passwort     
        </b>    
        </label>    
        <input type="Password" name="Pass" id="Pass" placeholder="Password">    
        <br><br>    
        <input type="button" name="log" id="log" value="Login">       
        <br><br>    
        <input type="checkbox" id="check">    
        <span>Remember me</span>    
        <br>
        <a href="#">Passwort vergessen</a>
        <br><br>    
        <form>
 		<input type="button" value="Zurück!" onclick="history.go(-1)">
		</form>  
    </form>     
</div>    
</body>    
</html>