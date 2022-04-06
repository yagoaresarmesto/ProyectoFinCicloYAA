<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Este es el Login:</h2>

		<form>
			Email: <input type="text" size="10"><br /> Contraseña: <input
				type="password" size="10"> <input type="submit"
				value="login"><br />
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>