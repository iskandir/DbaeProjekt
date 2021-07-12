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
				<form class="form-inline w-50 mx-2 d-none d-md-inline searchbar" autocomplete="off" accept-charset="utf-8">
					<div class="input-group">
						<input type="text" name="searchbar" class="form-control" placeholder="Shop durchsuchen...">
						<div class="input-group-append">
						<form class="search" method="GET" action="SearchServlet">
							<input type="submit" value="searchbar" id="searchBar" class="font-awesome btn btn-black" onChange="searching()">
							</form>
						</div>
					</div>
				</form> 
				<!--Menu upper-right corner-->
				<head:Header/>
			</nav>
		</div>
    </body>
</html>
    
  