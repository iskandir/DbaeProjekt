<!DOCTYPE>
<html>
    <head>
        <!--Auflistung der Autoren-->
        <meta name="authorOne" content="Dennis Hasselbusch">
        <meta name="authorTwo" content="Marten Kracke">
        <meta name="authorThree" content="Clemens Beck">

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
		
      
      <!--Head Bar-->
      <nav class="container d-none d-lg-flex" id="subnav">
        <ul class="nav">  
          <li class="navbar-nav ml-auto">
          <div class="dropdown">
           <button class="dropmenu"><img src="pictures/warenkorb.jpeg" alt="Käufer" width="20" height="20">
           <span class="float-right" style="color: red">Produkte</span>
		      <i class="fa fa-caret-down"></i>
		    </button>
            <div class="dropdown-content">
		      <a href="#">Hardware</a>
		      <a href="#">Peripherie</a>
		      <a href="#">Software</a>
		    </div>
          </div>
            <li class="nav-item">
              <a class="nav-link" href="/Outlet" title="Outlet">Deals</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/promotions.xhtml" title="Aktionen">Aktionen</a>
            </li>
        </ul>
      </nav>

    <div class="container">
      

        <br>

        <h1>Willkommen!</h1>
        <button>CLICK ME!</button>
    </div>
      </body>
 
</html>