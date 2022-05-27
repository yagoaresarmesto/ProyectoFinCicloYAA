<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Review Subida</title>
	<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		
			<table class="normal" width="60%">
				<tr>
					<td><h2>Tus reviews</h2></td>
					<td>&nbsp;</td>
					<td><h2>${loggedCustomer.nombrecompleto}</h2></td>
				</tr>
				<tr>
					<td colspan="3"><hr/></td>
				</tr>
				<tr>
					<td>
						<span id="book-title">${videojuego.titulo}</span><br/>
						<img src="data:image/jpg;base64,${videojuego.base64Image}" />
					</td>
					<td colspan="2">
						<h3>Tu review se ha subido con éxito!</h3>
					</td>
				</tr>
			</table>
		
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>