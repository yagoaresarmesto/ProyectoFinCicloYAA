<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Administrador</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

	<div class="contenedor-login">
		<form id="LoginForm" action="Login" method="post">

			<c:if test="${message !=null}">
				<div align="center">
					<h4>${message}</h4>
				</div>
			</c:if>

			<div class="login">
				<div class="form">
					<span class="material-icons"><img src="../images/logo.png"></span>
					<h2>Panel de administrador</h2>
					<input type="text" placeholder="Email" name="email" /> <input
						type="password" placeholder="Contraseña" name="contraseña" />
					<button type="submit">Inicia Sesión</button>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#LoginForm").validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					contraseña : "required",
				},
				messages : {
					email : {
						required : "Porfavor introduzca un correo",
						email : "Porfavor introduce una dirección válida"
					},

					contraseña : "Porfavor introduce una contraseña"
				}

			});

		});
	</script>
</body>


</html>