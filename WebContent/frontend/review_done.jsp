<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Subida</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="contenedor-videojuegos-detalle">
		<div class="contenedor-detalle-titulo">
			<h1>${ videojuego.titulo}</h1>
			<h3>(${ videojuego.compañia})</h3>
		</div>
		<div class="contenedor-detalle-estrellas">
		
		</div>
	</div>

	<div class="contenedor-videojuegos-detalle2">
		<div class="contenedor-detalle-imagen">
			<img src="data:image/jpg;base64,${videojuego.base64Image}"
				width="100%" height="100%" />

		</div>
		<div class="contenedor-detalle-descripcion">
			<h2>Tu review se ha subido con éxito</h2>
		</div>

		<div class="contenedor-detalle-botones">
		

		</div>
	</div>




	<br>
	<br>

	<jsp:directive.include file="footer.jsp" />


</body>
</html>