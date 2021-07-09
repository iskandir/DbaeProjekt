<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Warenkorb</title>
	
		<!--Viewport auf Basis des verw. Geräts mit Skalierung 10-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		
		 <!--Bootstrap via CDN hinzugefügt-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous" type="text/javascript"></script>
        <!--Css Stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/warenkorb.css">
	</head>
	<body>
		<jsp:include page="navBar.jsp" />
			
			
						
		<div class="container">
			<div class="row">
				<div class="col-75">
					<div class="checkout_container">
						<form class="bestellung" method="POST" action="BestellungServlet">
							<div class="row">
								<div class="col-50">
									<div class="row">
										<div class="col-25">
											<label for="hausnummer">Hausnummer</label> <input type="number" id="hausnummer" name="hausnummer" value="">
										</div>
										<div class="col-75">
											<label for="strasse">Strasse</label> <input type="text" id="strasse" name="strasse" value="">
										</div>	
									</div>
									<div class="row">
										<div class="col-25">
											<label for="postleitzahl">Postleitzahl</label> <input type="text"id="postleitzahl" name="postleitzahl" value="">
										</div>
										<div class="col-75">
											<label for="stadt">Stadt</label> <input type="text" id="stadt" name="stadt" value="">
										</div>
									</div>
								</div>
							</div>
							
							<input type="checkbox" name="agb_gelesen" required>
							<label for="agb_gelesen">Ich habe die AGB gelesen und bin mit deren Geltung einverstanden.</label>
							<input type="submit" value="Zahlungspflichtig bestellen" class="checkout_btn">
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>