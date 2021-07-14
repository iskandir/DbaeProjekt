<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<div class="grid-container">
		<p class="suchergebnisse">Suchergebnisse</p>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">Titel</th>
						<th scope="col">Beschreibung</th>
						<th scope="col">Link</th>
					</tr>
				</thead>
				<tbody style="font-size: 12px;">
					<c:forEach var="produkt" items="${suchergebnisse}">
						<tr>
							<td><c:out value="${produkt.titel}" /></td>
							<td><c:out value="${produkt.beschreibung}" /></td>
							<td>
								<form class="products" method="GET" action=DetailServlet>
									<input type="hidden" id="custId" name="p" value="${produkt.produktnummer}"> 
									<input class="btn btn-outline-info" type="submit" value="Details" name="" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>