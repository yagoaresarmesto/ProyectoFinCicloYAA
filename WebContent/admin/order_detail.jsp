<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalles Pedidos</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Detalles del pedido Id: ${pedido.pedidoId }</h2>
	</div>

	<c:if test="${message !=null}">
		<div align="center">
			<h4>${message}</h4>
		</div>
	</c:if>

	<div align="center">
		<h2>Vista previo de pedidos:</h2>
		<table>
			<tr>
				<td><b>Pedido Por: </b></td>
				<td>${pedido.cliente.nombrecompleto}</td>
			</tr>
			<tr>
				<td><b>Estado Pedido: </b></td>
				<td>${pedido.estadoPedido}</td>
			</tr>
			<tr>
				<td><b>Fecha de pedido: </b></td>
				<td>${pedido.fechaPedido}</td>
			</tr>
			<tr>
				<td><b>Método de Pago: </b></td>
				<td>${pedido.metodoPago}</td>
			</tr>
			<tr>
				<td><b>Total: </b></td>
				<td><fmt:formatNumber value="${pedido.total}" type="currency" /></td>
			</tr>

			<tr>
				<td><b>Nombre: </b></td>
				<td>${pedido.nombreDestinatario}</td>
			</tr>
			<tr>
				<td><b>Teléfono: </b></td>
				<td>${pedido.telefonoDestinatario}</td>
			</tr>
			<tr>
				<td><b>Dirección de envío: </b></td>
				<td>${pedido.direccionEnvio}</td>
			</tr>

		</table>


		<div align="center">
			<h2>Videojuegos Pedidos</h2>
			<table border="1">
				<tr>
					<th>Index</th>
					<th>Videojuego Título</th>
					<th>Compañia</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Subtotal</thd>
				</tr>
				<c:forEach items="${pedido.detallesPedidos}" var="detallesPedido"
					varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><img style="vertical-align: middle;"
							src="data:image/jpg;base64,${detallesPedido.videojuego.base64Image}"
							width="48" height="64" /> ${detallesPedido.videojuego.titulo}</td>
						<td>${detallesPedido.videojuego.compañia}</td>
						<td><fmt:formatNumber
								value="${detallesPedido.videojuego.precio}" type="currency" /></td>
						<td>${detallesPedido.cantidad}</td>
						<td><fmt:formatNumber value="${detallesPedido.subtotal}"
								type="currency" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">TOTAL:</td>

					<td>5</td>
					<td><fmt:formatNumber value="${pedido.total}" type="currency" />

					</td>
				</tr>
			</table>
		</div>

		<div align="center">
			<br /> <a href="edit_order?id=${pedido.pedidoId}">Editar este Pedido</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="">Eliminar este Pedido</a>
		</div>

		<jsp:directive.include file="footer.jsp" />
</body>
</html>