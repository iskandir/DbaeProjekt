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
<form class ="support" method="POST" action="LoginServlet">
    <div class="support">       
    	<h3>Hilfe holen</h3> <br/>
    	<h2>Support Ticket erstellen</h2> <br/>
    	

       
        
		<div class="anliegen"> 
			
			Vorname:
			</label><input type="text" name="Name"  placeholder="Gib deinen Vornamen ein">    
			Nachname:
			</label><input type="text" name="Name"  placeholder="Gib deinen Nachnahmen an">   <br><br>  
			
			E-Mail:
			<input type="email" name="email" placeholder="Gib deine e-mail Adresse ein"> <br><br>  
			Anliegen:
			<input type="text" placeholder="Art des Anliegens"> <br><br>  
			
			Betreff:
			<input type="text" name="Betreff"  placeholder="Art des Problems(=Betreff)"> <br><br> 
			
			<textarea id="anliegenAREA" rows="" cols=""></textarea>
		</div>
		


         
  
        <br><br>    
        <div class="box bg-1">
      
        <br>    

        <a href="#">Support Ticket abschicken</a>
        <br><br>    
 		<input type="button" value="Zurück!" onclick="history.go(-1)">
</form>  
		
   </div> 
</body>
</html>




