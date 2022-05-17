<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<title>Resultados para ${keyword }</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:if test="${fn:length(result) == 0}">
			<h2>No hay resultados para "${keyword}"</h2>
		</c:if>

		<c:if test="${fn:length(result) > 0}">

			<h2>Resultados para "${keyword }":</h2>
			<div align="center" style="width: 80%; margin: 0 auto">
				<div>
					<c:forEach items="${result }" var="videojuego">
						<div style="display: inline-block; margin: 10px;">
							<div>
								<a href="view_videogame?id=${videojuego.videojuegoId }"></a> <img
									src="data:image/jpg;base64,${videojuego.base64Image }"
									width="128" height="164" />
							</div>

						</div>
						<div>
							<div>
								<a href="view_videogame?id=${videojuego.videojuegoId }">
									${videojuego.titulo } </a>
							</div>


							<div>Valoración *****</div>
							<div>${videojuego.compañia }</div>
							<div>${videojuego.precio }</div>
						</div>
				</div>
				</c:forEach>
			</div>
		</c:if>
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