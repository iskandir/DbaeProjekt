<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
	<meta name="authors" content="Dennis Hasselbusch, Clemens Beck">
	
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!--Bootstrap via CDN hinzugefügt-->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
		
	<link rel="stylesheet" type="text/css" href="css/navigation.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">
      			<img src="pictures/pig.png" alt="" width="30" height="24">
    		</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page" href="index.jsp">Produkte</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><c:out value="${empty benutzer.username ? 'Benutzerkonto' : benutzer.username}" /></a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							
							<c:if test="${empty benutzer}">
								<li><a class="dropdown-item" href="anmelden.jsp">Anmelden</a></li>
								<li><a class="dropdown-item" href="registrieren.jsp">Registrieren</a></li>								
							</c:if>
							<c:if test="${not empty benutzer}">
								<li><a class="dropdown-item" href="WarenkorbServlet">Warenkorb</a></li>
								<li><a class="dropdown-item" href="abmelden.jsp">Abmelden</a></li>
							</c:if>
							
							<li><a class="dropdown-item" href="support.jsp" >Support</a></li>
							
							<c:if test="${benutzer.getEmail() == 'admin@macl.de' && benutzer.getUsername() == 'Admin'}">
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="admin.jsp">Administration</a></li>
							</c:if>
						</ul>
					</li>
				</ul>
				<form class="d-flex" method="GET" action=SuchenServlet>
					<input class="form-control me-2" name="suche" id="suche" type="search" placeholder="Suche" required>
					<button class="btn btn btn-outline-success" type="submit">Suchen</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>

