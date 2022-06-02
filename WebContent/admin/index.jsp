<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/estilos.css">
<title>Administration</title>
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administration</h2>
	</div>
	<hr>
	<div align="center">
		<h2>Acciones</h2>
		<b> <a href="new_videogame">Nuevo Videojuego</a> &nbsp; <a
			href="user_form.jsp">Nuevo Usuario</a> &nbsp; <a
			href="category_form.jsp">Nueva Categoria</a> &nbsp; <a
			href="customer_form.jsp">Nuevo Cliente</a> &nbsp;
		</b>
	</div>
	<hr>
	<div align="center">
		
		<h2 class="pageheading">Ventas Recientes:</h2>
		<table border="1">
			<tr>
				<th>Pedido ID</th>
				<th>Pedido por</th>
				<th>Videojuego Copias</th>
				<th>Total</th>
				<th>Método de pago</th>
				<th>Estado</th>
				<th>Fecha Pedido</th>
			</tr>
			<c:forEach items="${listaVentasRecientes}" var="pedido"
				varStatus="status">
				<tr>
					<td><a href="view_order?id=${pedido.pedidoId}">${pedido.pedidoId}</a></td>
					<td>${pedido.cliente.nombrecompleto}</td>
					<td>${pedido.videogameCopies}</td>
					<td><fmt:formatNumber value="${pedido.total}" type="currency" /></td>
					<td>${pedido.metodoPago}</td>
					<td>${pedido.estadoPedido}</td>
					<td>${pedido.fechaPedido}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
		<div align="center">
		<h2 class="pageheading">Estadísiticas:</h2>
		Total Usuarios: ${totalUsuarios} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Videojuegos: ${totalVideojuegos} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Clientes: ${totalClientes} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Reviews: ${totalReviews} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Pedidos: ${totalPedidos}
		
		<hr width="60%" />
	</div>	
	<hr>



	<jsp:directive.include file="footer.jsp" />
</body>
</html>