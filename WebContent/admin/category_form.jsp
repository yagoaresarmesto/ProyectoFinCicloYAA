<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:if test="${categoria != null}">
	Editar Categoria
	</c:if> <c:if test="${categoria == null}">
		Crear nueva categoria
			</c:if></title>

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
			<c:if test="${categoria != null}">
	Editar Categoria
	</c:if>
			<c:if test="${categoria == null}">
		Crear nueva categoria
			</c:if>
		</h2>
	</div>
	<hr>
	<div align="center">
		<c:if test="${categoria != null}">
			<form action="update_category" method="post" id="categoryForm">
				<input type="hidden" name="categoriaId"
					value="${categoria.categoriaId }">
		</c:if>
		<c:if test="${categoria == null}">
			<form action="create_category" method="post" id="categoryForm">
		</c:if>
		<table>
			<tr>
				<td align="right">Nombre:</td>
				<td align="left"><input type="text" id="nombre" name="nombre"
					size="20" value="${categoria.nombre}" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save">
					<button id="buttonCancel">Cancelar</button></td>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#categoryForm").validate({
			rules : {
				nombre : "required",
			},

			messages : {
				nombre : "Porfavor introduzca un nombre de categoría"
			}
		});
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
</script>

</html>