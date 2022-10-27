<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Tienda On-line</title>
</head>
<body>
	<div class="container">
		<h1>Tienda On-line</h1>
		<h2>${applicationScope.nombreTienda}</h2>
		<h4>Alta de producto</h4>
		<div class="container border border-warning">
		<span>Usuario: ${sessionScope.usuario.nombre }</span>
		</div>
		<!-- Error -->
		<div class="container border border-warning">
			${requestScope.error}
		</div>
		<!-- Error -->
		<div class="container border border-dark">
			<form id="f1" method="post" action="altaProducto">
			  <div class="mb-3">
			    <label for="descripcion" class="form-label">Descripción</label>
			    <input type="text" class="form-control" id="descripcion" name="descripcion">
			  </div>
			  <div class="mb-3">
			    <label for="precio" class="form-label">Precio</label>
			    <input type="text" class="form-control" id="precio" name="precio" placeholder="1.0">
			  </div>
			  <div>
			    <button type="submit" class="btn btn-primary mb-3">Enviar</button>
			  </div>
			</form>
		</div>
	</div>
</body>
</html>