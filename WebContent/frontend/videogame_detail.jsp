<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>

<title>${videojuego.titulo}</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />


	<div class="contenedor-videojuegos-detalle">
		<div class="contenedor-detalle-titulo">
			<h1>${ videojuego.titulo}</h1>
			<h3>(${ videojuego.compañia})</h3>
		</div>
		<div class="contenedor-detalle-estrellas">
			<jsp:directive.include file="videogame_rating.jsp" />
			<a href="#reviews">${fn:length(videojuego.reviews)} Reviews</a>
			<h2>$${videojuego.precio}</h2>
		</div>
	</div>

	<div class="contenedor-videojuegos-detalle2">
		<div class="contenedor-detalle-imagen">
			<img src="data:image/jpg;base64,${videojuego.base64Image}"
				width="100%" height="100%" />

		</div>
		<div class="contenedor-detalle-descripcion">
			${videojuego.descripcion}</div>
			
			<div class="contenedor-detalle-botones">
		<button class="boton-carrito" id="buttonAddToCart">Añadir al carrito <i class="fa-solid fa-cart-shopping"></i></button>
		<br><br><br><br>
		<button class="boton-review" id="buttonWriteReview">Escribe una Review <i class="fa-solid fa-star"></i></button>	
			
			</div>
	</div>

	<div class="contenedor-videojuegos-detalle3">
		<div class="contenedor-detalle-reviews">
			<table>
			<h2 id="reviews">Reviews de los usuarios</h2>
				<c:forEach items="${videojuego.reviews}" var="review">
					<tr>
						<td><c:forTokens items="${review.stars}" delims=","
								var="star">
								<c:if test="${star eq 'on'}">
									<img src="images/rating_on.png" />
								</c:if>
								<c:if test="${star eq 'off'}">
									<img src="images/rating_off.png" />
								</c:if>
							</c:forTokens> - <b>${review.encabezado}</b></td>
					</tr>
					<tr>
						<td>by ${review.cliente.nombrecompleto} on
							${review.reviewFecha}</td>
					</tr>
					<tr>
						<td><i>${review.comentario}</i></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>





<br><br>

	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#buttonWriteReview").click(function() {
				window.location = 'write_review?videogame_id=' + ${videojuego.videojuegoId};
			});

			$("#buttonAddToCart").click(function() {
				window.location = 'add_to_cart?videogame_id=' + ${videojuego.videojuegoId};
			});
		});
	</script>
</body>
</html>