<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Nuevo Usuario</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<h2>
			<c:if test="${usuario != null}">
	Editar Usuario
	</c:if>
			<c:if test="${usuario == null}">
		Crear nuevo usuario
			</c:if>
		</h2>
	</div>
	<hr>
	<div align="center">
		<c:if test="${usuario != null}">
			<form action="update_user" method="post" id="userForm">
				<input type="hidden" name="usuarioId" value="${usuario.usuarioId }">
		</c:if>
		<c:if test="${usuario == null}">
			<form action="create_user" method="post" id="userForm">
		</c:if>
		<table>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${usuario.email}" /></td>
			</tr>
			<tr>
				<td align="right">Apellidos:</td>
				<td align="left"><input type="text" id="apellidos"
					name="apellidos" size="20" value=${usuario.apellidos }></td>
			</tr>
			<tr>
				<td align="right">Contrase�a:</td>
				<td align="left"><input type="password" id="contrase�a"
					name="contrase�a" size="20" value=${usuario.contrase�a }></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Guardar">
					
					<button id="buttonCancel"> Cancelar</button>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>


<script type="text/javascript">
	$(document).ready(function(){
		$("#userForm").validate({
			rules : {
				email: {
					required: true,
					email: true
				},
				apellidos: "required",
				contrase�a: "required",
				
			},
			
			messages: {
				email: {
					required: "Porfavor introduzca un correo",
					email: "Porfavor introduce una direcci�n v�lida"
				},
				
				apellidos: "Porfavor introduce los apellidos",
				contrase�a: "Porfavor introduce una contrase�a"
			}
			
		});	
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});	
</script>

</html>