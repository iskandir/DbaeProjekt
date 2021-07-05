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
<form method="POST" action="LoginServlet">
    <h2>Login</h2><br>    
    <div class="login">       
        <label><b>Benutzername   
        </b>    
        </label>    
        
        <input type="text" name="username" id="Uname" placeholder="Username">    
        <br><br>    
        <label><b>Passwort     
        </b>    
        </label>    
        <input type="Password" name="password" id="Pass" placeholder="Password">    
        <br><br>    
        <input type="submit" value="Login!">       
        <br><br>    

        <a href="#">Passwort vergessen</a>
        <br><br>    
 		<input type="button" value="Zurück!" onclick="history.go(-1)">
		</form>  
   </div>
   
</body>    
</html>