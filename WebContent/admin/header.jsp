<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header-admin">
	<div class="contenedor-logo-admin">
		<a href="${pageContext.request.contextPath}/admin/"> <img
			src="https://cdn.pccomponentes.com/img/logos/logo-pccomponentes.svg"
			width="120" height="80">
		</a>
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
		| <a href="list_videojuegos">Videojuegos</a> | <a href="list_customer">Clientes</a> | <a href="list_review">Reviews</a>
		| <a href="">Pedidos</a> |
	</b>
</div>