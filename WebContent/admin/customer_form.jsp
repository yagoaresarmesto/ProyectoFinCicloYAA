<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Nuevo Cliente</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<h2>
			<c:if test="${cliente != null}">
	Editar Cliente
	</c:if>
			<c:if test="${cliente == null}">
		Crear Nuevo Cliente
			</c:if>
		</h2>
	</div>
	<hr>
	<div align="center">
		<c:if test="${cliente != null}">
			<form action="update_customer" method="post" id="customerForm">
				<input type="hidden" name="clienteId" value="${cliente.clienteId }" />
		</c:if>
		<c:if test="${cliente == null}">
			<form action="create_customer" method="post" id="customerForm">
		</c:if>
		<table>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="45" value="${cliente.email}" /></td>
			</tr>
			<tr>
				<td align="right">Nombre Completo:</td>
				<td align="left"><input type="text" id="nombreCompleto"
					name="nombreCompleto" size="45" value="${cliente.nombrecompleto}" /></td>
			</tr>

			<tr>
				<td align="right">Contraseña:</td>
				<td align="left"><input type="password" id="contraseña"
					name="contraseña" size="45" value="${cliente.contraseña}" /></td>
			</tr>

			<tr>
				<td align="right">Confirmar Contraseña:</td>
				<td align="left"><input type="password"
					id="confirmarContraseña" name="confirmarContraseña" size="45"
					value="${cliente.contraseña}" /></td>
			</tr>

			<tr>
				<td align="right">Telefono:</td>
				<td align="left"><input type="text" id="telefono"
					name="telefono" size="45" value="${cliente.telefono}" /></td>
			</tr>

			<tr>
				<td align="right">Dirección:</td>
				<td align="left"><input type="text" id="direccion"
					name="direccion" size="45" value=${cliente.direccion } /></td>
			</tr>

			<tr>
				<td align="right">Ciudad:</td>
				<td align="left"><input type="text" id="ciudad" name="ciudad"
					size="45" value=${cliente.ciudad } /></td>
			</tr>

			<tr>
				<td align="right">Código Postal:</td>
				<td align="left"><input type="text" id="codigoPostal"
					name="codigoPostal" size="45" value=${cliente.codigopostal } /></td>
			</tr>

		<tr>
				<td align="right">País:</td>
				<td align="left"><input type="text" id="pais" name="pais"
					size="45" value=${cliente.pais } /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save">

					<button id="buttonCancel">Cancelar</button>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>


<script type="text/javascript">

$(document).ready(function() {
	$("#customerForm").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			nombreCompleto: "required",
			contraseña: "required",
			
			confirmarContraseña: {
				required: true,
				equalTo: "#contraseña"
			},
			
			telefono: "required",								
			direccion: "required",
			ciudad: "required",
			codigoPostal: "required",
			pais: "required",
		},
		
		messages: {
			email: {
				required: "Porfavor introduce una dirección",
				email: "Porfavor introduce una dirección válida"
			},
			
			nombreCompleto: "Porfavor introducza nombre completo",
			contraseña: "Porfavor introduce una contraseña",
			
			confirmarContraseña: {
				required: "Porfavor, cofirma contraseña",
				equalTo: "No coinciden las contraseña"
			},
			
			telefono: "Porfavor introduce un teléfono",								
			direccion: "Porfavor introduzca una contraseña",
			ciudad: "Porfavor introduce una ciudad",
			codigoPostal: "Porfavor introduce un código postal",
			pais: "Porfavor introduce un pais",
		}
	});
	
	$("#buttonCancel").click(function() {
		history.go(-1);
	});
});
</script>

</html>