<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<title>Lista de prductos</title>
</head>
<body>
	<div class="container">
		<h1>Tienda On-line</h1>
		<h2>${applicationScope.nombreTienda}</h2>
		<h4>Lista de productos</h4>
	</div>
	<div class="container border border-warning">
		<div>Usuario: ${sessionScope.usuario.nombre }</div>
		<div><i>${requestScope.mensaje}</i></div>
	</div>
	<div class="container border border-black">
		<form action="comprar" method="get">
			<div><label>Id: </label> <input type="text" name="idProducto"></div>
			<div><label>Cantidad: </label> <input type="number" name="cantidad" value="1" min="1"></div>
			<button>Compar</button>
		</form>
	</div>
	<ul>
		<c:forEach var="producto" items="${requestScope.lista}">
			<div class="border border-black">
			<li>
				<ul>
				<li>ID: ${producto.idProducto}</li>
				<li>Descripción: ${producto.descripcion}</li>
				<li>Precio ${producto.precio} &euro;</li>
				<li>Stock: ${producto.stock}</li>
<%-- 				<li><a href="comprar?idProducto=${producto.idProducto}" class="btn btn-primary">Comprar</a></li> --%>
				</ul>
			</li>
			</div>
			
		</c:forEach>
	</ul>
</body>
</html>