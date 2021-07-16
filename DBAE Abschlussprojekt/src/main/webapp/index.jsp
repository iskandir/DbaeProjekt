<%@ taglib uri="WEB-INF/taglibs/produktlisting.tld" prefix="produkte" %>

<!DOCTYPE>
<html>
<head>
	<title>Verkaufsplattform IT</title>

	<meta name="author" content="Dennis Hasselbusch">

	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<jsp:include page="navigation.jsp" />
	
	<produkte:Produktlisting/>
</body>
</html>