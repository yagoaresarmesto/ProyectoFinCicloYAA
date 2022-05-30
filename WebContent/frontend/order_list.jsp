<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historial de Pedidos</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Historial de Pedidos</h2>
	</div>

	<c:if test="${fn:length(listaPedidos) == 0}">
		<div align="center">
			<h3>No hay ningún pedido registrado.</h3>
		</div>
	</c:if>

	<c:if test="${fn:length(listaPedidos) > 0}">
		<div align="center">
			<table border="1" cellpadding="5">
				<tr>
					<th>Index</th>
					<th>Pedido ID</th>
					<th>Cantidad</th>
					<th>Total</th>
					<th>Fecha de Pedido</th>
					<th>Estado</th>
					<th>Acciones</th>
				</tr>
				<c:forEach var="pedido" items="${listaPedidos}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${pedido.pedidoId}</td>
						<td>${pedido.videogameCopies}</td>
						<td><fmt:formatNumber value="${pedido.total}" type="currency"
								currencySymbol="$" /></td>
						<td>${pedido.fechaPedido}</td>
						<td>${pedido.estadoPedido}</td>
						<td><a href="show_order_detail?id=${pedido.pedidoId}">Ver Detalles</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<jsp:directive.include file="footer.jsp" />


</body>
</html>