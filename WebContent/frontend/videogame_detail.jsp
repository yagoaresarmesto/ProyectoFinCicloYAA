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
<title>${videojuego.titulo}</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<table width="80%" style="border:0">
			<tr>
				<td colspan="3" align="left">
					<h2>${ videojuego.titulo}</h2> by ${ videojuego.compañia}
				</td>
			</tr>
			<tr>
				<td rowspan="2"><img
					src="data:image/jpg;base64,${videojuego.base64Image}" width="240"
					height="300" /></td>
				<td valign="top" align="left">Calificación *****</td>

				<td valign="top" rowspan="2" width="20%">
				<h2>$${videojuego.precio}</h2><br /> 
					<button type="submit">Añadir al carrito</button>
				</td>
			</tr>
			<tr>
				<td valign="top">${videojuego.descripcion}</td>
			</tr>
			<tr></tr>
			<tr>
				<td><h2>Reviews</h2></td>
				<td colspan="2">
					<button>Escribe tu opinión</button>
				</td>
			</tr>
		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>