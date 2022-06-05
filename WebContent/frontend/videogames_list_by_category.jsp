<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<title>Videojuegos de ${categoria.nombre}</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />


	<div align="center" style="clear: both">
		<div class="contenedor_videojuegos">
				<h2>${categoria.nombre}</h2>
			<c:forEach items="${listaVideojuegos }" var="videojuego">
				<a href="view_videogame?id=${videojuego.videojuegoId }">
					<div class="videojuego">
						<img src="data:image/jpg;base64,${videojuego.base64Image }"
							width="128" height="164" class="videojuego__detalles-imagen" />
						<div class="videojuego'__detalles">
							<h4 class="encabezado--centrado">${videojuego.titulo }</h4>

							<div class="videojuego-datos">
								<jsp:directive.include file="videogame_rating.jsp" />
								<h5>${videojuego.compañia }</</h5>
								<p>${videojuego.precio }</</p>
							</div>
						</div>

					</div>
				</a>
			</c:forEach>
		</div>
	</div>
	
	

</body>
</html>