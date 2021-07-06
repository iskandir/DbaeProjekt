<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>supportForm</title>
<link rel="stylesheet" type="text/css" href="css/support.css"> 
</head>
<body>

<jsp:include page="navBar.jsp"/>

<form class ="support" method="POST" action="SupportServlet">
        
    	<h3>Hilfe holen</h3> <br/>
    	<h2>Support Ticket erstellen</h2> <br/>
    	

		<div class="anliegen"> 
			
			Vorname:
			<input type="text" name="Name"  required placeholder="Gib deinen Vornamen ein" maxlength="30"> 
			   
			Nachname:
			<input type="text" name="Nachname"  required placeholder="Gib deinen Nachnahmen an" maxlength="30">   <br><br>  
			
			E-Mail:
			<input type="email" name="Email" required placeholder="Gib deine e-mail Adresse ein" maxlength="120"> <br><br>
			
			Betreff:
			<input type="text" name="Betreff"  required placeholder="Art des Problems(=Betreff)" maxlength="120"> <br><br> 
			
			<label for="anliegenInhalt">Anliegen</label>
			<textarea id="anliegenInhalt" name = "Inhalt" rows="" cols="100" maxlength="1500"></textarea>
			
		</div>
         
  
        <br><br>    
        <div class="box bg-1"> 
      
        <br>    
        
        <input type="submit" value="Support-Ticket abschicken">

        <br><br>    
 		<input type="button" value="Zurück!" onclick="history.go(-1)">
 		
 	</div> 
</form>  
		
   
</body>
</html>




