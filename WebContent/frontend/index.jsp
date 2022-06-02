<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<title>Videojuegos Yago</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<h2>Categorias</h2>

	<div align="center">
		<h2>Nuevos juegos</h2>
		<div align="center" style="width: 80%; margin: 0 auto">

			<c:forEach items="${listaNuevosVideojuegos }" var="videojuego">
				<div style="display: inline-block; margin: 10px;">
					<div>
						<a href="view_videogame?id=${videojuego.videojuegoId }"></a> <img
							src="data:image/jpg;base64,${videojuego.base64Image }"
							width="128" height="164" />
					</div>
					<div>
						<a href="view_videogame?id=${videojuego.videojuegoId }">
							${videojuego.titulo } </a>
					</div>

					<jsp:directive.include file="videogame_rating.jsp" />
					<div></div>
					<div>${videojuego.compañia }</div>
					<div>${videojuego.precio }</div>
				</div>

			</c:forEach>
		</div>
		<div align="center" style="clear: both">
			<h2>Más vendidos</h2>
			<div align="center" style="width: 80%; margin: 0 auto">

			<c:forEach items="${listVideojuegoMasVendidos }" var="videojuego">
				<div style="display: inline-block; margin: 10px;">
					<div>
						<a href="view_videogame?id=${videojuego.videojuegoId }"></a> <img
							src="data:image/jpg;base64,${videojuego.base64Image }"
							width="128" height="164" />
					</div>
					<div>
						<a href="view_videogame?id=${videojuego.videojuegoId }">
							${videojuego.titulo } </a>
					</div>

					<jsp:directive.include file="videogame_rating.jsp" />
					<div></div>
					<div>${videojuego.compañia }</div>
					<div>${videojuego.precio }</div>
				</div>

			</c:forEach>
			
		</div>
		<div align="center" style="clear: both">
			<h2>Favoritos</h2>
		</div>
	</div>


	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
		window.addEventListener("scroll", function() {
			var header = document.querySelector("header");
			header.classList.toggle("header_abajo", window.scrollY > 0)
		})
	</script>
</body>
</html>