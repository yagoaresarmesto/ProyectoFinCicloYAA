<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manejar Categorias</title>
<link rel="stylesheet" href="../css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Administración de Categorias</h2>
		<h3>
			<a href="category_form.jsp">Crear nueva Categoria</a>
		</h3>
	</div>

	<c:if test="${message !=null}">
		<div align="center">
			<h4>${message}</h4>
		</div>
	</c:if>

	<div align="center">

		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Nombre</th>
				<th>Acciones</th>
			</tr>
			<c:forEach var="cat" items="${listaCategoria}" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${cat.categoriaId}</td>
					<td>${cat.nombre}</td>
					<td><a href="edit_category?id=${cat.categoriaId}">Editar</a>&nbsp;
						<a href="javascript:void(0);" class="deleteLink" id="${cat.categoriaId}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:directive.include file="footer.jsp" />

	<script>
	
	$(document).ready(function(){
	$(".deleteLink").each(function(){
		$(this).on("click", function(){
			categoriaId = $(this).attr("id");
			if (confirm('¿Quiere eliminar esta categoría con ID ' + categoriaId
					+ ' ?')) {
				window.location = 'delete_category?id=' + categoriaId;
		}
	});
	});
	});
	
	
	</script>
</body>
</html>