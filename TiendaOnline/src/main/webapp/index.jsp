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
	<title>Tienda On-line</title>
</head>
<body>
	<div class="container">
		<h1>Tienda On-line</h1>
		<h2>${applicationScope.nombreTienda}</h2>
		<!-- Error -->
		<div class="container border border-warning">
			<span>Usuario: ${sessionScope.usuario.nombre }</span>
		</div>
		<div class="container border border-dark">	
			  <div class="mb-3">
			   	<a class="btn btn-primary" href="listaProductos" role="button">Lista</a>
			  </div>
			  <c:if test="${sessionScope.usuario.rol=='Administrador'}">
			  <div class="mb-3">
			    <a class="btn btn-primary" href="alta-producto.jsp" role="button">Altas</a>
			  </div>
			  </c:if>
		</div>
	</div>
</body>
</html>