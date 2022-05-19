<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Clientes</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administración de Clientes</h2>
		<h3>
			<a href="customer_form.jsp">Crear nuevo Cliente</a>
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
				<th>Email</th>
				<th>Nombre Completo</th>
				<th>Ciudad</th>
				<th>Pais</th>
				<th>Fecha Registro</th>
				<th>Acciones</th>
			</tr>
			<c:forEach var="cliente" items="${listaCliente}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${cliente.clienteId}</td>
					<td>${cliente.email}</td>
					<td>${cliente.nombrecompleto}</td>
					<td>${cliente.ciudad}</td>
					<td>${cliente.pais}</td>
					<td>${cliente.fechaRegistro}$</td>

					<td><a href="edit_customer?id=${cliente.clienteId}">Editar</a>&nbsp;
						<a href="javascript:void(0)" class="deleteLink"
						id="${cliente.clienteId}">Eliminar</a></td>
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