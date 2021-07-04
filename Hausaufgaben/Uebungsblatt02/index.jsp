<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/taglib/meineTaglibs.tld" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--Auflistung aller Autoren mit vollständigem Namen-->
	<meta name="authorOne" content="Dennis Hasselbusch">
	<meta name="authorThree" content="Clemens Beck">
	<meta name="authorTwo" content="Marten Kracke">
	<!-- Bootstrap Verlinkung über offizielle Webadresse -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<title>Startseite </title>
</head>
<body>
	<div class ="container">
	<!-- Erstes Taglibs zum ausblenden des Menüs -->
	<my:Nav>
		<jsp:include page="jsp/navigationbar.jsp"/>
	</my:Nav>	
	
	<h2>Willkommen bei unserer Übung 2.</h2>
	Du kannst dich <a href="login.jsp"> einloggen </a> oder du <a href="registrierung.jsp"> registrierst </a> dich...

	<!-- Zweites Taglibs zum einblenden der Willkommensnachricht an den User -->
	<my:Benutzer/>
	
	
	<p> Abgabe von: Dennis Hasselbusch, Clemens Beck, Marten Kracke </p>
	
	
</div>
</body>
</html>