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
		<h1>Lista de clientes</h1>
		<table class="table table-bordered table-dark">
			<tr><th>Nombre</th><th>Apellido</th><th>Número de Cuentas</th><th>Opciones</th></tr>
			<c:forEach var="cliente" items="${requestScope.lista}" varStatus="loop">
			<tr>
				<td>${cliente.firstName}</td>
				<td>${cliente.lastName}</td>
				<td>${cliente.numOfAccounts}</td>
				<td><a href="cuentasCliente?idCliente=${loop.index}&nombre=${cliente.firstName}&apellido=${cliente.lastName}" class="btn btn-secondary">Cuentas</a></td>
			</tr>
			</c:forEach>
		</table>
		<div class="btn-group">
			<a href="javascript:history.back()" class="btn btn-danger">Anterior</a>
			<a href="index.jsp" class="btn btn-success">Menú principal</a>
		</div>
	</div>
</body>
</html>