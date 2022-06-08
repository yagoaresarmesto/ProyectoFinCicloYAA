<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Nuevo Videojeugo</title>
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
			<c:if test="${videojuego != null}">
	Editar Videojuego
	</c:if>
			<c:if test="${videojuego == null}">
		Crear nuevo videojuego
			</c:if>
		</h2>
	</div>
	<hr>
	<div align="center">
		<c:if test="${videojuego != null}">
			<form action="update_videogame" method="post" id="videogameForm"
				enctype="multipart/form-data">
				<input type="hidden" name="videojuegoId"
					value="${videojuego.videojuegoId }"/>
		</c:if>
		<c:if test="${videojuego == null}">
			<form action="create_videogame" method="post" id="videogameForm"
				enctype="multipart/form-data">
		</c:if>
		<table>
			<tr>
				<td align="right">Categoria:</td>
				<td><select name="categoria">
						<c:forEach items="${listaCategoria}" var="categoria">
							<c:if
								test="${ categoria.categoriaId eq videojuego.categoria.categoriaId}">
								<option value="${categoria.categoriaId }" selected>
							</c:if>
							<c:if
								test="${ categoria.categoriaId ne videojuego.categoria.categoriaId}">
								<option value="${categoria.categoriaId }">
							</c:if>
						
								${categoria.nombre}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="right">Titulo:</td>
				<td align="left"><input type="text" id="titulo" name="titulo"
					size="20" value="${videojuego.titulo}" /></td>
			</tr>
			<tr>
				<td align="right">Compañia:</td>
				<td align="left"><input type="text" id="compañia"
					name="compañia" size="20" value=${videojuego.compañia }></td>
			</tr>

			<tr>
				<td align="right">Fecha lanzamiento:</td>
				<td align="left"><input type="text" id="fechaLanzamiento"
					name="fechaLanzamiento" size="20"
					value="<fmt:formatDate pattern= 'MM/dd/yyyy' value='${videojuego.fechaPublicacion }' />" /></td>
			</tr>

			</tr>
			<tr>
				<td align="right">Imagen Videojuego:</td>
				<td align="left"><input type="file" id="videojuegoImagen"
					name="videojuegoImagen" size="20" /> <br> <img id="thumbnail"
					alt="Imagen Preview" style="width: 40px; margin-top: 10px;"
					src="data:image/jpg;base64,${videojuego.base64Image }" /></td>
			</tr>
			<tr>
				<td align="right">Precio:</td>
				<td align="left"><input type="text" id="precio" name="precio"
					size="20" value=${videojuego.precio }></td>
			</tr>

			<tr>
				<td align="right">Descripción:</td>
				<td align="left"><textarea rows="5" cols="50"
						name="descripcion" id="descripcion">${videojuego.descripcion }</textarea>
				</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Guardar">

					<button id="buttonCancel">Cancelar</button>
			</tr>
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>


<script type="text/javascript">

	$(document).ready(function() {
		$('#fechaLanzamiento').datepicker();
		$('#videojuegoImagen').change(function(){
			showImageThumbnail(this);
		});
		
		$("#videogameForm").validate({
			rules: {
				categoria: "required",
				titulo: "required",
				compañia: "required",
				fechaLanzamiento: "required",
				
				<c:if test="${videogame == null}">
				videojuegoImagen: "required",
				</c:if>
				
				precio: "required",
				descripcion: "required",
			},
			
			messages: {
				categoria: "Selecciona una categoria",
				titulo: "Selecciona un titulo",
				compañia: "Selecciona una compañia",
				fechaLanzamiento: "Selecciona una fecha de lanzamiento",
				videojuegoImagen: "Selecciona una imagen ",
				precio: "Selecciona un precio",
				descripcion: "Selecciona una descripción"
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	
	function showImageThumbnail(fileInput){
	var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
</script>

</html>