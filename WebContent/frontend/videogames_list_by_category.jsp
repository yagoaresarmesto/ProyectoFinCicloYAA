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


	<div align="center">
		<h2>${categoria.nombre}</h2>
	</div>

	<div align="center" style="width: 80% margin: 0 auto">

		<c:forEach items="${listaVideojuegos }" var="videojuego">
			<div style="float: left; display: inline-block; margin: 10px;">
				<div>
					<a href="view_videogame?id=${videojuego.videojuegoId }"></a> <img
						src="data:image/jpg;base64,${videojuego.base64Image }" width="128"
						height="164" />
				</div>
				<div>
					<a href="view_videogame?id=${videojuego.videojuegoId }">
						${videojuego.titulo } </a>
				</div>
				<div>
					<jsp:directive.include file="videogame_rating.jsp" />
				
				</div>
				<div>${videojuego.compa�ia }</div>
				<div>${videojuego.precio }</div>
			</div>

		</c:forEach>
	</div>

	<jsp:directive.include file="footer.jsp" />


</body>
</html>