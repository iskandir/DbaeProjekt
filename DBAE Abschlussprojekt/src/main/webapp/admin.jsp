<!DOCTYPE>
<html> 
	<head>
		<!--Auflistung der Autoren-->
		<meta name="authorOne" content="Dennis Hasselbusch">
		<meta name="authorTwo" content="Marten Kracke">
		<meta name="authorThree" content="Clemens Beck">
		
		<!--Beschreibung der Seite-->
		<meta name="description" content="Admin Center">
		
		<!--Kleines Icon-->
		<link rel="shortcut icon" href= "Iconsmind-Outline-Eci-Icon.ico" type="image/x-icon">
		
		<!--Viewport auf Basis des verw. Geräts mit Skalierung 10-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<title>Administration</title>
		
		<!--Bootstrap via CDN hinzugefügt-->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">      
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous"></script>
		<!--Css Stylesheet -->
		<link rel="stylesheet" type="text/css" href="css/myStyle.css">
		
	</head>
	<body>
		<jsp:include page="navBar.jsp"/>
		  		
		<div class="container-fluid">
			<div class="row h-50">
		        <div class="col-sm-12 my-auto">
		            <div class="card card-block w-25 mx-auto">
						<h3>Produkte</h3>
						<form class ="products" method="POST" action=AdminServlet>
							<input type="submit" value="Produkte" name="details"/>
						</form>
					</div>
		        </div>
		        
		        <div class="col-sm-12 my-auto">
		            <div class="card card-block w-25 mx-auto">
		           		<h3>Bestellungen</h3>
						<form class ="products" method="POST" action=AdminServlet>
							<input type="submit" value="Bestellungen" name="details"/>
						</form>
		            </div>
		        </div>
		        
		        <div class="col-sm-12 my-auto">
		            <div class="card card-block w-25 mx-auto">
						<h3>Kunden</h3>
						<form class ="products" method="POST" action=AdminServlet>
							<input type="submit" value="Kunden" name="details"/>
						</form>
					</div>
		        </div> 
	        	        
		        <div class="col-sm-12 my-auto">
		            <div class="card card-block w-25 mx-auto">
		           		<h3>Warenkorb</h3>
						<form class ="products" method="POST" action=WarenkorbServlet>
							<input type="submit" value="Warenkorb" name="details"/>
						</form>
		            </div>
		        </div>
			</div>
		</div>
	</body>
</html>