<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div class="contenedor-login">
		<form id="LoginForm" action="login" method="post">


			<div class="login">
				<div class="form">
					<span class="material-icons"><img src="./images/logo.png"></span>
					<input type="text" placeholder="Email" name="email" /> <input
						type="password" placeholder="Contraseña" name="contraseña" />
					<button type="submit">Inicia Sesión</button>
					<br>
					<br> <a href="register">Aún no tiene cuenta? Registrese
						aquí</a>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${message !=null}">
		<div align="center">
			<h4>${message}</h4>
		</div>
	</c:if>





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