<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Escribe una review</title>
<link rel="stylesheet" href="css/estilos.css">
<script src="https://kit.fontawesome.com/f5b5688fc0.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<form id="reviewForm">
			<table class="normal" width="60%">
				<tr>
					<td><h3>Ya has escrito una review en este videojuego</h3></td>
					<td>&nbsp;</td>
					<td><h2>${loggedCustomer.nombrecompleto}</h2></td>
				</tr>
				<tr>
					<td colspan="3"><hr/></td>
				</tr>
				<tr>
					<td>
						<span>${videojuego.titulo}</span><br/>
						<img src="data:image/jpg;base64,${videojuego.base64Image}" />
					</td>
					<td>
					    <div id="rateYo"></div>
						<br/>
						<input type="text" name="encabezado" size="60" readonly="readonly" value="${review.encabezado}" />
						<br/>
						<br/>
						<textarea name="comentario" cols="70" rows="10" readonly="readonly" >${review.comentario}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit">Enviar</button>
						&nbsp;&nbsp;
						<button id="buttonCancel">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
	
	<script type="text/javascript">

	$(document).ready(function() {
			
		$("#rateYo").rateYo({
			starWidth: "40px",
			fullStar: true,
			rating: ${review.clasificacion}
		    readOnly: true
			}
		});		
	});
	</script>
</body>


</html>