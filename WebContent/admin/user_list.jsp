<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Usuarios</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administraci�n de Usuarios</h2>
		<h3>
			<a href="user_form.jsp">Crear nuevo Usuario</a>
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
				<th>Acciones</th>
			</tr>
			<c:forEach var="usuario" items="${listaUsuarios}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${usuario.usuarioId}</td>
					<td>${usuario.email}</td>
					<td>${usuario.apellidos}</td>
					<td><a href="edit_user?id=${usuario.usuarioId}">Editar</a>&nbsp;
						<a href="javascript:confirmDelete(${usuario.usuarioId})">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:directive.include file="footer.jsp" />

	<script>
		function confirmDelete(usuarioId) {
			if (confirm('�Quiere eliminar este usuario con ID ' + usuarioId
					+ ' ?')) {
				window.location = 'delete_user?id=' + usuarioId;
			}
		}
	</script>
</body>
</html>