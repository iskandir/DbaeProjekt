<%@ taglib uri="WEB-INF/taglibs/headertags.tld" prefix="head" %>
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
				<a href="index.jsp">
					<img class="img-fluid header-logo" src="pictures/pig.png" height="50" width="50" alt="companyName">
				</a>
				<form method="get" action="/listing.xhtml" class="form-inline w-50 mx-2 d-none d-md-inline searchbar" enctype="application/x-www-form-urlencoded" autocomplete="off" name="search_word_inc" accept-charset="utf-8">
					<div class="input-group">
						<input type="text" name="q" class="form-control" onkeyup="global.handleSuggestLayer(event, this, {})" inputmode="search" placeholder="Shop durchsuchen...">
						<div class="input-group-append">
							<input type="submit" value="suchen" class="font-awesome btn btn-black">
						</div>
					</div>
				</form> 
				<!--Menu upper-right corner-->
				<head:Header/>
			</nav>
		</div>
    </body>
</html>
    
  