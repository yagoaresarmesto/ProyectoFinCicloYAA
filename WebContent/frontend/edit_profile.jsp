<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar nuevo cliente</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="css/jquery-ui.min.css">
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<h2>Editar Perfil</h2>
	</div>
	<hr>
	<div align="center">
		<form action="update_profile" method="post" id="customerForm">

			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left">${loggedCustomer.email}(No se puede
						modificar)</td>
				</tr>
				<tr>
					<td align="right">Nombre Completo:</td>
					<td align="left"><input type="text" id="nombreCompleto"
						name="nombreCompleto" size="45"
						value="${loggedCustomer.nombrecompleto }" /></td>
				</tr>

				<tr>
					<td align="right">Telefono:</td>
					<td align="left"><input type="text" id="telefono"
						name="telefono" size="45" value="${loggedCustomer.telefono }" /></td>
				</tr>

				<tr>
					<td align="right">Direcci�n:</td>
					<td align="left"><input type="text" id="direccion"
						name="direccion" size="45" value="${loggedCustomer.direccion }"></td>
				</tr>

				<tr>
					<td align="right">Ciudad:</td>
					<td align="left"><input type="text" id="ciudad" name="ciudad"
						size="45" value="${loggedCustomer.ciudad }"></td>
				</tr>

				<tr>
					<td align="right">C�digo Postal:</td>
					<td align="left"><input type="text" id="codigoPostal"
						name="codigoPostal" size="45"
						value="${loggedCustomer.codigopostal }" /></td>
				</tr>

				<tr>
					<td align="right">Pa�s:</td>
					<td align="left"><input type="text" id="pais" name="pais"
						size="45"value="${loggedCustomer.pais }"></td>
				</tr>
				<tr>
					<td>Deja en blanco la contrase�a si no la desea cambiar la contrase�a</td>
				</tr>

				<tr colspan="2" align="center">
					<td align="right">Contrase�a:</td>
					<td align="left"><input type="password" id="contrase�a"
						name="contrase�a" size="45" /></td>
				</tr>

				<tr>
					<td align="right">Confirmar Contrase�a:</td>
					<td align="left"><input type="password"
						id="confirmarContrase�a" name="confirmarContrase�a" size="45" /></td>
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
			rules : {
				email : {
					required : true,
					email : true
				},
				nombreCompleto : "required",

				confirmarContrase�a : {
					equalTo : "#contrase�a"
				},

				telefono : "required",
				direccion : "required",
				ciudad : "required",
				codigoPostal : "required",
				pais : "required",
			},

			messages : {
				email : {
					required : "Porfavor introduce una direcci�n",
					email : "Porfavor introduce una direcci�n v�lida"
				},

				nombreCompleto : "Porfavor introducza nombre completo",

				confirmarContrase�a : {
					equalTo : "No coinciden las contrase�a"
				},

				telefono : "Porfavor introduce un tel�fono",
				direccion : "Porfavor introduzca una contrase�a",
				ciudad : "Porfavor introduce una ciudad",
				codigoPostal : "Porfavor introduce un c�digo postal",
				pais : "Porfavor introduce un pais",
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
</script>

</html>