<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tu Perfil</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<br />
		<h2>Welcome, ${loggedCustomer.nombrecompleto}</h2>
		<br />
		<table>
			<tr>
				<td><b>Correo:</b></td>
				<td>${loggedCustomer.email}</td>
			</tr>
				<tr>
				<td><b>Nombre Completo:</b></td>
				<td>${loggedCustomer.nombrecompleto}</td>
			</tr>
			<tr>
				<td><b>Número de teléfono:</b></td>
				<td>${loggedCustomer.telefono}</td>
			</tr>
			<tr>
				<td><b>Ciudad:</b></td>
				<td>${loggedCustomer.ciudad}</td>
			</tr>
			<tr>
				<td><b>Código postal:</b></td>
				<td>${loggedCustomer.codigopostal}</td>
			</tr>
			<tr>
				<td><b>Pais:</b></td>
				<td>${loggedCustomer.pais}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><b><a href="edit_profile">Edit
							Mi Perfil</a></b></td>
			</tr>
		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>