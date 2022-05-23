<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Reviews</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administración de Reviews</h2>
	</div>

	<c:if test="${message !=null}">
		<div align="center">
			<h4>${message}</h4>
		</div>
	</c:if>

	<div align="center">

		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Videojuego</th>
				<th>Clasificación</th>
				<th>Encabezado</th>
				<th>Cliente</th>
				<th>Fecha Review</th>
				<th>Acciones</th>
			</tr>
			<c:forEach var="review" items="${listaReviews}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${review.reviewId}</td>
					<td>${review.videojuego.titulo}</td>
					<td>${review.clasificacion}</td>
					<td>${review.encabezado}</td>
					<td>${review.cliente.nombrecompleto}</td>
					<td>${review.reviewFecha}</td>
					<td><a href="edit_review?id=${review.reviewId}">Editar</a>&nbsp;
						<a href="javascript:void(0);" class="deleteLink"
						id="${review.reviewId}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:directive.include file="footer.jsp" />

	<script>
		$(document)
				.ready(
						function() {
							$(".deleteLink")
									.each(
											function() {
												$(this)
														.on(
																"click",
																function() {
																	reviewId = $(
																			this)
																			.attr(
																					"id");
																	if (confirm('¿Quiere eliminar esta review con ID '
																			+ reviewId
																			+ ' ?')) {
																		window.location = 'delete_review?id='
																				+ reviewId;
																	}
																});
											});
						});
	</script>
</body>
</html>