<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
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
		<div class="container border border-dark">
			<form id="f1" method="post" action="login">
			  <div class="mb-3">
			    <label for="descripcion" class="form-label">Usuario</label>
			    <input type="text" class="form-control" id="usuario" name="usuario">
			  </div>
			  <div class="mb-3">
			    <label for="precio" class="form-label">Rol</label>
				<select class="form-select" id="rol" name="rol">
					<option value="Cliente">Cliente</option>
					<option value="Administrador">Administrador</option>
				</select>
			  </div>
			  <div>
			    <button type="submit" class="btn btn-primary mb-3">Enviar</button>
			  </div>
			</form>
		</div>
	</div>

</body>
</html>