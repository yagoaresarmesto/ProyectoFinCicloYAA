<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Pedidos</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administracion de Pedidos de Videojuegos</h2>
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
			<th>Pedido ID</th>
			<th>Pedido por</th>
			<th>Numero de Videojuegos</th>
			<th>Total</th>
			<th>Método de pago</th>
			<th>Estado</th>
			<th>Fecha de Pedido</th>
			<th>Acciones</th>
		</tr>
		<c:forEach var="pedido" items="${listaPedido}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${pedido.pedidoId}</td>
				<td>${pedido.cliente.nombrecompleto}</td>
				<td>${pedido.videogameCopies}</td>
				<td><fmt:formatNumber value="${pedido.total}" type="currency" currencySymbol="$"/></td>

				<td>${pedido.metodoPago}</td>
				<td>${pedido.estadoPedido}</td>
				<td>${pedido.fechaPedido}</td>
				<td><a href="view_order?id=${pedido.pedidoId}">Detalles</a> &nbsp;
					<a href="edit_order?id=${pedido.pedidoId}">Editar</a> &nbsp; <a
					href="javascript:void(0);" class="deleteLink" id="${pedido.pedidoId}">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<jsp:directive.include file="footer.jsp" />

	
</body>
</html>