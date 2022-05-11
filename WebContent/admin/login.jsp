<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

	<div align="center">
		<h1>Administración</h1>
		<h2>Login</h2>

		<c:if test="${message !=null}">
			<div align="center">
				<h4>${message}</h4>
			</div>
		</c:if>
		<form id="LoginForm" action="Login" method="post">

			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" size="20"></td>

				</tr>

				<tr>
					<td>Contraseña:</td>
					<td><input type="password" name="contraseña" size="20"></td>

				</tr>

				<tr>
					<td>

						<button type="submit">Login</button>

					</td>

				</tr>
			</table>

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