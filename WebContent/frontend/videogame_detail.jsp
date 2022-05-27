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

	<div align="center">
		<table width="80%" style="border: 0">
			<tr>
				<td colspan="3" align="left">
					<h2>${ videojuego.titulo}</h2> by ${ videojuego.compañia}
				</td>
			</tr>
			<tr>
				<td rowspan="2"><img
					src="data:image/jpg;base64,${videojuego.base64Image}" width="240"
					height="300" /></td>
				<td valign="top" align="left"><jsp:directive.include
						file="videogame_rating.jsp" /> <a href="#reviews">${fn:length(videojuego.reviews)}
						Reviews</a></td>

				<td valign="top" rowspan="2" width="20%">
					<h2>$${videojuego.precio}</h2> <br />
					<button type="submit">Añadir al carrito</button>
				</td>
			</tr>
			<tr>
				<td valign="top">${videojuego.descripcion}</td>
			</tr>
			<tr></tr>
			<tr>
				<td><h2>
						<a id="reviews">Reviews</a>
					</h2></td>
				<td colspan="2">
					<button id="buttonWriteReview">Write a Customer Review</button>
				</td>
			</tr>

			<tr>
				<td colspan="3" align="left">
					<table>
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
				</td>
			</tr>
		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#buttonWriteReview").click(function() {
				window.location = 'write_review?videogame_id=' + ${videojuego.videojuegoId};
			});
		});
	</script>
</body>
</html>