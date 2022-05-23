<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Review</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<h2>Editar Review</h2>
	</div>
	<hr>
	<div align="center">

		<form action="update_review" method="post" id="reviewForm">
			<input type="hidden" name="reviewId" value="${review.reviewId }">

			<table>
				<tr>
					<td align="right">Nombre:</td>
					<td align="left"><b>${review.videojuego.titulo }</b></td>
				</tr>

				<tr>
					<td align="right">Valoración:</td>
					<td align="left"><b>${review.clasificacion }</b></td>
				</tr>

				<tr>
					<td align="right">Cliente:</td>
					<td align="left"><b>${review.cliente.nombrecompleto }</b></td>
				</tr>
				<tr>
					<td align="right">Encabezado:</td>
					<td align="left"><input type="text" size="60"
						name="encabezado" value="${review.encabezado }" /></td>
				</tr>

				<tr>
					<td align="right">Comentario:</td>
					<td align="left"><textarea rows="5" cols="70"
							name="comentario">${review.comentario}</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save">
						<button id="buttonCancel">Cancelar</button></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reviewForm").validate({
			rules : {
				encabezado : "required",
				comentario : "required"
			},

			messages : {
				encabezado : "Porfavor introduce un encabezado",
				comentario : "Porfavor introduce un comentario",
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
</script>

</html>