<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Videojuegos</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administración de Videojuegos</h2>
		<h3>
			<a href="new_videogame">Crear nuevo Videojuego</a>
		</h3>
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
				<th>Imagen</th>
				<th>Titulo</th>
				<th>Compañia</th>
				<th>Categoria</th>
				<th>Precio</th>
				<th>Fecha de lanzamiento</th>
				<th>Acciones</th>
			</tr>
			<c:forEach var="videojuego" items="${listaVideojuegos}"
				varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${videojuego.videojuegoId}</td>

					<td><img
						src="data:image/jpg;base64,${videojuego.base64Image }" widht="84"
						height="110" /></td>
					<td>${videojuego.titulo}</td>
					<td>${videojuego.compañia}</td>
					<td>${videojuego.categoria.nombre}</td>
					<td>${videojuego.precio}$</td>
					<td><fmt:formatDate pattern='MM/dd/yyyy'
							value='${videojuego.fechaPublicacion }' /></td>
					<td><a href="edit_videogame?id=${videojuego.videojuegoId}">Editar</a>&nbsp;
						<a href="javascript:void(0)" class="deleteLink"
						id="${videojuego.videojuegoId}">Eliminar</a></td>
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
																	videojuegoId = $(
																			this)
																			.attr(
																					"id");
																	if (confirm('¿Quiere eliminar este videojuego con ID '
																			+ videojuegoId
																			+ ' ?')) {
																		window.location = 'delete_videogame?id='
																				+ videojuegoId;
																	}
																});
											});
						});
	</script>
</body>
</html>