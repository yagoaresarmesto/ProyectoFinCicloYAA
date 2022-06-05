<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Escribe una review</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div class="contenedor-videojuegos-detalle">
		<div class="contenedor-detalle-titulo">
			<h1>Mi review: ${ videojuego.titulo}</h1>
			<h3>(${ videojuego.compañia})</h3>
		</div>
		<div class="contenedor-detalle-estrellas"></div>
	</div>

	<form id="reviewForm" action="submit_review" method="post">
		<div class="contenedor-videojuegos-detalle2-comentario">

			<div class="contenedor-detalle-imagen">
				<img src="data:image/jpg;base64,${videojuego.base64Image}"
					width="100%" height="100%" />

			</div>
			<div class="contenedor-detalle-comentario">
				<div id="rateYo"></div>
				<input type="hidden" id="rating" name="rating" /> <input
					type="hidden" name="videojuegoId"
					value="${videojuego.videojuegoId}" /> <br /> <input
					class="input-general" type="text" name="encabezado" size="60"
					placeholder="Encabezado del comentario(obligatorio)" /> <br /> <br />
				<textarea class="input-general" name="comentario" cols="105"
					rows="15" placeholder="Escribe los detalles"></textarea>
				<br> <br>
				<tr>
					<td colspan="3" align="center">
						<button class="botones-review-aceptar" type="submit">Enviar</button> &nbsp;&nbsp;
						<button class="botones-review-cancelar" id="buttonCancel">Cancelar</button>
					</td>
				</tr>

			</div>
		</div>
	</form>


	<br>
	<br>

	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {

			$("#buttonCancel").click(function() {
				history.go(-1);
			});

			$("#reviewForm").validate({
				rules : {
					encabezado : "required",
					comentario : "required"
				},

				messages : {
					encabezado : "Porvafor, introduce un encabezado",
					comentario : "Porfavor, introduce un comentario"
				}
			});

			$("#rateYo").rateYo({
				starWidth : "40px",
				fullStar : true,
				onSet : function(rating, rateYoInstance) {
					$("#rating").val(rating);
				}
			});
		});
	</script>
</body>


</html>