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
	<div align="center">
		<form action="update_profile" method="post" id="customerForm">

			<div class="form">

				Correo: ${loggedCustomer.email}(Nose puede modificar) <br> <br>
				<input type="text" id="nombreCompleto" class="input-general"
					name="nombreCompleto" placeholder="Nombre" size="45"
					value="${loggedCustomer.nombrecompleto }" /> <input type="text"
					id="telefono" class="input-general" name="telefono"
					placeholder="Tel�fono" size="45"
					value="${loggedCustomer.telefono }" /> <input type="text"
					id="direccion" class="input-general" name="direccion"
					placeholder="Direcci�n" size="45"
					value="${loggedCustomer.direccion }" /> <input type="text"
					id="ciudad" name="ciudad" class="input-general"
					placeholder="Ciudad" size="45" value="${loggedCustomer.ciudad }">
				<input type="text" id="codigoPostal" class="input-general"
					name="codigoPostal" placeholder="C�digo Postal" size="45"
					value="${loggedCustomer.codigopostal }" /> <input type="text"
					id="pais" name="pais" placeholder="Pa�s" class="input-general"
					size="45" value="${loggedCustomer.pais }"> Deja en blanco
				si no quieres cambiar la contrasela <input type="password"
					id="contrase�a" class="input-general" name="contrase�a"
					placeholder="Nueva Constrase�a" size="45" /> <input
					type="password" id="confirmarContrase�a" class="input-general"
					name="confirmarContrase�a" placeholder="Repite Contrase�a"
					size="45" /> <input type="submit" value="Guardar">

				<button id="buttonCancel">Cancelar</button>

			</div>
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