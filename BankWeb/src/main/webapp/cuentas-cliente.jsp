<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Banco On-line</title>
</head>
<body>
	<div class="container">
		<h1>Cuentas Cliente</h1>
		<table class="table table-bordered table-dark">
			<tr><th>Nº</th><th>Saldo</th></tr>
			<c:forEach var="cuenta" items="${requestScope.lista}" varStatus="loop">
			<tr>
				<td>${loop.index+1}</td>
				<td>${cuenta.balance}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>