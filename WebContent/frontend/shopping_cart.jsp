<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2>Carrito</h2>

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


			<form action="update_cart" method="post" id="cartForm">
				<div>
					<table border="1">
						<tr>
							<th>No</th>
							<th colspan="2">Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
							<th></th>
						</tr>
						<c:forEach items="${carrito.items}" var="item" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td><img
									src="data:image/jpg;base64,${item.key.base64Image}"
									width="80px" /></td>
								<td><span id="book-title">${item.key.titulo}</span></td>
								<td><input type="hidden" name="videojuegoId"
									value="${item.key.videojuegoId}" /> <input type="text"
									name="quantity${status.index + 1}" value="${item.value}"
									size="5" /></td>
								<td><fmt:formatNumber value="${item.key.precio}"
										type="currency" /></td>
								<td><fmt:formatNumber
										value="${item.value * item.key.precio}" type="currency" /></td>
								<td><a
									href="remove_from_cart?videogame_id=${item.key.videojuegoId}">Remove</a></td>
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
				</div>

				<div>
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit">Actualizar</button></td>
							<td><input type="button" id="clearCart" value="Limpiar Carrito" /></td>
							<td><a href="${pageContext.request.contextPath}/">Continuar
									Comprando </a></td>
							<td><a href="checkout">Checkout</a>
						</tr>
					</table>
				</div>
			</form>
		</c:if>
		<jsp:directive.include file="footer.jsp" />


		<script type="text/javascript">
	
		$(document).ready(function() {
			$("#clearCart").click(function() {
				window.location = 'clear_cart';
			});
			
			$("#cartForm").validate({
				rules : {
					<c:forEach items="${carrito.items}" var="item" varStatus="status">
						quantity${status.index + 1}: {
							required: true, number: true, min: 1
						},
					</c:forEach>
				},

				messages : {
					<c:forEach items="${carrito.items}" var="item" varStatus="status">
						quantity${status.index + 1}: { 
							required: "Porvafor introducza una cantidad",
							number: "La cantidad debe ser un número",
							min: "La cantidad tiene que ser mayor a 0"
						},
					</c:forEach>					
				}
			});

		});
	</script></body>


</html>