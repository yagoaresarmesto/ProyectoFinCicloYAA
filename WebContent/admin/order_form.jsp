<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edita Pedido</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Edita el pedido Id: ${pedido.pedidoId }</h2>
	</div>

	<c:if test="${message !=null}">
		<div align="center">
			<h4>${message}</h4>
		</div>
	</c:if>

	<form action="update_order" method="post" id="orderForm">
		<div align="center">
			<h2>Vista previo de pedidos:</h2>
			<table>
				<tr>
					<td><b>Pedido por</b></td>
					<td>${pedido.cliente.nombrecompleto}</td>
				</tr>
				<tr>
					<td><b>Order Date: </b></td>
					<td>${pedido.fechaPedido}</td>
				</tr>
				<tr>
					<td><b>Nombre: </b></td>
					<td><input type="text" name="nombreDestinatario"
						value="${pedido.nombreDestinatario}" size="45" /></td>
				</tr>
				<tr>
					<td><b>Teléfono: </b></td>
					<td><input type="text" name="telefonoDestinatario"
						value="${pedido.telefonoDestinatario}" size="45" /></td>
				</tr>

				<tr>
					<td><b>Enviar a: </b></td>
					<td><input type="text" name="direccionEnvio"
						value="${pedido.direccionEnvio}" size="45" /></td>
				</tr>
				<tr>
					<td><b>Payment Method: </b></td>
					<td><select name="metodoPago">
							<option value="contraRembolso">Contra rembolso</option>
					</select></td>
				</tr>
				<tr>
					<td><b>Order Status: </b></td>
					<td><select name="estadoPedido">
							<option value="enProceso">En proceso</option>
							<option value="enviando">Enviando</option>
							<option value="enviado">Enviado</option>
							<option value="completado">Completado</option>
							<option value="cancelado">Cancelado</option>
					</select></td>
				</tr>
			</table>
		</div>

		<div align="center">
			<h2>Videojuegos Pedidos</h2>
			<table border="1">
				<tr>
					<th>Index</th>
					<th>Videojuego Título</th>
					<th>Compañia</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
				<c:forEach items="${pedido.detallesPedidos}" var="detallesPedido"
					varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${detallesPedido.videojuego.titulo}</td>
						<td>${detallesPedido.videojuego.compañia}</td>
						<td><fmt:formatNumber
								value="${detallesPedido.videojuego.precio}" type="currency" /></td>
						<td><input type="hidden" name="videojuegoId"
							value="${detallesPedido.videojuego.videojuegoId}" /> <input
							type="text" name="cantidad${status.index + 1}"
							value="${detallesPedido.cantidad}" size="5" /></td>
						<td><fmt:formatNumber value="${detallesPedido.subtotal}"
								type="currency" /></td>
						<td><a
							href="remove_videogame_from_order?id=${detallesPedido.videojuego.videojuegoId }">Eliminar</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">TOTAL:</td>

					<td>${pedido.videogameCopies}</td>
					<td><fmt:formatNumber value="${pedido.total}" type="currency" />

					</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div align="center">
			<br /> <a href="javascript:showAddVideogamePopup()">Añadir
				videojuegos</a> <input type="submit" value="Save" /> <input
				type="button" value="Cancel"
				onclick="javascript:window.location.href='list_order';" />
		</div>
	</form>
	<jsp:directive.include file="footer.jsp" />

	<script>
		function showAddVideogamePopup() {
			var width = 600;
			var height = 250;
			var left = (screen.width - width) / 2;
			var top = (screen.height - height) / 2;

			window.open('add_videogame_form', '_blank', 'width=' + width
					+ ', height=' + height + ', top=' + top + ', left=' + left);
		}
		
		
		$(document).ready(function() {
			$("#orderForm").validate({
				rules : {
					nombreDestinatario: "required",
					telefonoDestinatario: "required",
					direccionEnvio: "required",
					
					<c:forEach items="${pedido.detallesPedidos}" var="videojuego" varStatus="status">
				     cantidad${status.index + 1}: {
					required: true, number: true, min: 1
				},
			</c:forEach>
					
				},

				messages : {
					nombreDestinatario: "Porfavor, introduce un nombre",
					telefonoDestinatario: "Porfavor, introduce un teléfono",
					direccionEnvio: "Porfavor, introduce una dirección",
					
					<c:forEach items="${pedido.detallesPedidos}" var="videojuego" varStatus="status">
				    cantidad${status.index + 1}: { 
					required: "Porvafor introducza una cantidad",
					number: "La cantidad debe ser un número",
					min: "La cantidad tiene que ser mayor a 0"
				},
			</c:forEach>	
				}
			});
			$("#buttonCancel").click(function() {
				history.go(-1);
			});
		});
	</script>
</body>
</html>