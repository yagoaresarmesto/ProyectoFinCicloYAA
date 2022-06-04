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


	<div class="carrousel">

		<div class="css-slider">

			<div></div>

			<div></div>

			<div></div>

			<div></div>

		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center" style="clear: both">
		<div class="contenedor_videojuegos">
			<h2>Juegos del momento</h2>
			<c:forEach items="${listaNuevosVideojuegos }" var="videojuego">
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


	<div align="center" style="clear: both">
		<div class="contenedor_videojuegos">
			<h2>Los más exitosos</h2>
			<c:forEach items="${listVideojuegoMasVendidos }" var="videojuego">
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






	<div align="center" style="clear: both">
	<br>
		<jsp:directive.include file="footer.jsp" />
	</div>
	<script type="text/javascript">
		window.addEventListener("scroll", function() {
			var header = document.querySelector("header");
			header.classList.toggle("header_abajo", window.scrollY > 0)
		})
	</script>
</body>
</html>