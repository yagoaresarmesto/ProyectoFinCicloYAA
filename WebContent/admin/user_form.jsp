<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Nuevo Usuario</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Crear nuevo usuario</h2>
	</div>
	<hr>
	<div align="center">
		<form action="create_user" method="post"
			onsubmit="return validateFormInput()">
			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						size="20" /></td>
				</tr>
				<tr>
					<td align="right">Apellidos:</td>
					<td align="left"><input type="text" id="apellidos"
						name="apellidos" size="20" /></td>
				</tr>
				<tr>
					<td align="right">Contrase�a:</td>
					<td align="left"><input type="password" id="contrase�a"
						name="contrase�a" size="20" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save">
						<input type="button" value="Cancel" onclick="javascript:history.go(-1);"></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>


<script type="text/javascript">
	function validateFormInput() {

		var fieldEmail = document.getElementById("email");
		var fieldFullname = document.getElementById("apellidos");
		var fieldPassword = document.getElementById("contrase�a");

		if (fieldEmail.value.length == 0) {

			alert("Email es requerido!!!");

			fieldEmail.focus();

			return false;

		}

		if (fieldFullname.value.length == 0) {

			alert("Apellidos es requerido!!!");

			fieldFullname.focus();

			return false;

		}

		if (fieldPassword.value.length == 0) {

			alert("Contrase�a es requerida!!!");

			fieldPassword.focus();

			return false;

		}
	}
</script>

</html>