<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:if test="${message !=null}">
			<div align="center">
				<h4>${message}</h4>
			</div>
		</c:if>


		<c:set var="carrito" value="${sessionScope['carrito']}" />

		<c:if test="${carrito.totalItems == 0}">
			<h2>No hay videojuegos en el carrito</h2>
		</c:if>

		<c:if test="${carrito.totalItems > 0}">
			<div>
				<h2>
					Revisa tus pedidos <a href="view_cart">Editar</a>
				</h2>
				<table border="1">
					<tr>
						<th>Num</th>
						<th colspan="2">Videojuego</th>
						<th>Compañia
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Subtotal</th>
					</tr>
					<c:forEach items="${carrito.items}" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td><img src="data:image/jpg;base64,${item.key.base64Image}"
								width="80px" /></td>
							<td><span id="book-title">${item.key.titulo}</span></td>
							<td>${item.key.compañia }</td>

							<td><fmt:formatNumber value="${item.key.precio}"
									type="currency" /></td>
							<td><input type="text" name="quantity${status.index + 1}"
								value="${item.value}" size="5" readonly="readonly" /></td>

							<td><fmt:formatNumber
									value="${item.value * item.key.precio}" type="currency" /></td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td><b>${carrito.totalQuantity} videojuego(s)</b></td>
						<td>Total:</td>
						<td colspan="2"><b><fmt:formatNumber
									value="${carrito.totalAmount}" type="currency" /></b></td>
					</tr>
				</table>

				<h2>Tu información</h2>
				<form id="orderForm" action="place_order" method="post">
					<table>
						<tr>
							<td>Nombre Destinatario:</td>
							<td><input type="text" name="nombreDestinatario"
								value="${loggedCustomer.nombrecompleto}" /></td>
						</tr>
						<tr>
							<td>Teléfono:</td>
							<td><input type="text" name="telefono"
								value="${loggedCustomer.telefono}" /></td>
						</tr>
						<tr>
							<td>Dirección:</td>
							<td><input type="text" name="direccion"
								value="${loggedCustomer.direccion}" /></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" name="ciudad"
								value="${loggedCustomer.ciudad}" /></td>
						</tr>

						<tr>
							<td>Zip Code:</td>
							<td><input type="text" name="codigoPostal"
								value="${loggedCustomer.codigopostal}" /></td>
						</tr>
						<tr>
							<td>Pais:</td>
							<td><input type="text" name="pais"
								value="${loggedCustomer.pais}" /></td>
						</tr>
					</table>

					<div>
						<h2>Pago</h2>
						Selecciona método de pago: &nbsp;&nbsp;&nbsp; <select
							name="paymentMethod">
							<option value="Contra Rembolso">Contra Rembolso</option>
						</select>
					</div>
					<div>
						<table>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td></td>
								<td><button type="submit">Realizar Pedido</button></td>
								<td><a href="${pageContext.request.contextPath}/">Continuar
										Comprando </a></td>
							</tr>
						</table>
					</div>
				</form>

			</div>

		</c:if>
		<jsp:directive.include file="footer.jsp" />
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
		$("#orderForm").validate({
			rules: {
				nombreDestinatario: "required",
				telefono: "required",
				direccion: "required",
				ciudad: "required",
				codigoPostal: "required",
				pais: "required",
			},
			
			messages: {
				nombreDestinatario: "Porfavor, introduce un nombre",
				telefono: "Porfavor, introduce un teléfono",
				direccion: "Porfavor, introduce una dirección",
				ciudad: "Porfavor, introduce una ciudad",
				codigoPostal: "Porfavor, introduce un código postal",
				pais: "Porfavor, introduce un país",					
			}
			
		});

	});
	</script>
</body>


</html>