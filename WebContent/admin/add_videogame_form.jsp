<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añade un videojuego a tu pedido</title>
</head>
<body>
	<div align="center">
		<h2>Añade videojuego con PedidoId: ${pedido.pedidoId}</h2>
		<form action="add_videogame_to_order" method="post">
			<table>
				<tr>
					<td>Selecciona un videojuego:</td>
					<td>
					<select name="videogameId">
					      <c:forEach items="${listaVideojuego}" var="videojuego" varStatus="status">
						<option value="${videojuego.videojuegoId}"> ${videojuego.titulo} - ${videojuego.compañia} </option>	
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Núemro de copias</td>
					<td><select name="cantidad">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Añadir" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="button" value="Cancelar" onclick="javascript: self.close();" />
					</td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>