<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header-admin">
	<div class="contenedor-logo-admin">
		<img
			src="https://cdn.pccomponentes.com/img/logos/logo-pccomponentes.svg"
			width="120" height="80">
	</div>
	<div class="contenedor-titulo-admin">
	PANEL DE ADMINISTRACIÓN
	</div>

	<div class="contenedor-login-logout-admin">
		Bienvenido, <c:out value="${sessionScope.useremail }"/> | <a href="logout">Logout</a>
	</div>
</header>



<div align="center">

</div>

<div align="center">
	<b> <a href="list_usuarios">Usuarios</a> | <a href="list_category">Categorias</a>
		| <a href="">Videojuegos</a> | <a href="">Clientes</a> | <a href="">Reviews</a>
		| <a href="">Pedidos</a> |
	</b>
</div>