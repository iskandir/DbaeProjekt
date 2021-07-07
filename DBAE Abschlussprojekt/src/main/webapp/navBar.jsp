<!DOCTYPE>
<html>
    <head>
    <!--Bootstrap via CDN hinzugefügt-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous"></script>
        <!--Css Stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/myStyle.css">
    </head>
    <body>
    
      <!--Navigation Bar-->
		<div class="shadow-sm">
			<nav class="container navbar justify-content-between navbar-toggleable-md" id="mainnav">    
				<img class="img-fluid header-logo" src="pictures/pig.png" height="50" width="50" alt="companyName">
				<form method="get" action="/listing.xhtml" class="form-inline w-50 mx-2 d-none d-md-inline searchbar" enctype="application/x-www-form-urlencoded" autocomplete="off" name="search_word_inc" accept-charset="utf-8">
					<div class="input-group">
						<input type="text" name="q" class="form-control" onkeyup="global.handleSuggestLayer(event, this, {})" inputmode="search" placeholder="Shop durchsuchen...">
						<div class="input-group-append">
							<input type="submit" value="suchen" class="font-awesome btn btn-black">
						</div>
					</div>
				</form> 
				<!--Menu upper-right corner-->
				<div class="btn-group" role="group">
					<div class="navbar-nav ml-auto">
						<div class="dropdown">
							<button class="dropbtn"><img src="pictures/buyerIcon.png" alt="Käufer" width="20" height="20"><span class="float-right">Käufer</span>
								<i class="fa fa-caret-down"></i>
							</button>
							<div class="dropdown-content">
								<a href="login.jsp">Login</a>
								<a href="#">Kundenkonto erstellen</a>
								<a href="#">Mein Konto</a>
								<a href="#">Persönliche Daten</a>
								<a href="supportForm.jsp">Support</a>
							</div>
						</div> 
					</div> 
					<div class="navbar-nav ml-auto">
						<div class="dropdown">
							<button class="dropbtn"><img src="pictures/adminLog.png" alt="Administrator" width="20" height="20"><span class="float-right">Administrator</span> 
								<i class="fa fa-caret-down"></i>
							</button>
							<div class="dropdown-content">
								<a href="login.jsp">Login</a>
								<a href="adminCenter.jsp">Admin Center</a>
							</div>
						</div> 
					</div> 
				</div>  
			</nav>
		</div>
    </body>
</html>
    
  