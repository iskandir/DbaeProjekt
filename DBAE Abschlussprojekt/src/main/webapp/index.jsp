<%@ taglib uri="WEB-INF/taglibs/logintags.tld" prefix="log" %>

<!DOCTYPE>
<html>
    <head>
        <meta name="author" content="Dennis Hasselbusch">

        <!--Beschreibung der Seite-->
        <meta name="description" content="DBAE Abschlussprojekt">

        <!--Kleines Icon-->
        <link rel="shortcut icon" href= "Iconsmind-Outline-Eci-Icon.ico" type="image/x-icon">

        <!--Viewport auf Basis des verw. Geräts mit Skalierung 10-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <title>Elektrotechnik MaClDe GmbH</title>

        <!--Bootstrap via CDN hinzugefügt-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous"></script>
        <!--Css Stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/myStyle.css">
    </head>
    <body>
		<jsp:include page="navBar.jsp"/>
    
	    <div class="container">
	    	<log:Login/>
	    	
	    	<!-- TODO 
	    	Produkte auflisten, vlt mit TagLibs?  -->
	    </div>
   	</body>
 
</html>
