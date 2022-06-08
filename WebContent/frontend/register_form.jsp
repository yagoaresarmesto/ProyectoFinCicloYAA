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



	<div class="login">
		<form action="register_customer" method="post" id="customerForm">
			<div class="form">
				<span class="material-icons"><img src="./images/logo.png"></span> <input type="text"
					id="email" name="email" placeholder="Email" /> <input type="text"
					id="nombreCompleto" name="nombreCompleto"
					placeholder="Nombre y apellidos" /> <input type="password"
					id="contrase�a" name="contrase�a" placeholder="Contrase�a" /> <input
					type="password" id="confirmarContrase�a" name="confirmarContrase�a"
					placeholder="Repita contrase�a" /> <input type="text"
					id="telefono" name="telefono" placeholder="Tel�fono" /> <input
					type="text" id="direccion" name="direccion" placeholder="Direcci�n" />
				<input type="text" id="ciudad" name="ciudad" placeholder="Ciudad" />
				<input type="text" id="codigoPostal" name="codigoPostal"
					placeholder="C�digo Postal" /> <input type="text" id="pais"
					name="pais" placeholder="Pa�s" />

				<button type="submit">Registrarse</button>
				<br> <br> <a href="login">Ya tiene cuenta?
					Inicia sesi�n aqu�</a>
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
				contrase�a : "required",

				confirmarContrase�a : {
					required : true,
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
				contrase�a : "Porfavor introduce una contrase�a",

				confirmarContrase�a : {
					required : "Porfavor, cofirma contrase�a",
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