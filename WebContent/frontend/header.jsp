<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${loggedCustomer==null}">
	<!-- Si el usuario no está logeado se muestra este menú -->
	<header class="header">
		<div class="contenedor-logo">
			<a href="${pageContext.request.contextPath}/"> <img
				src="./images/logo.png"
				width="120" height="80">
			</a>
		</div>
		<div class="contenedor-buscador">

			<form action="search" method="get" class="search-bar">
				<input type="text" placeholder="Busca en LVCVSGAMES">
		    	<button type="submit" value="Search">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>

		<div class="contenedor-botones-1">
			<a href="login">
				<button type="submit">
					<i class="fa-solid fa-arrow-right-to-bracket">&nbsp;</i>
				</button>
			</a>
		</div>

		<div class="contenedor-botones-2">
			<a href="register">
				<button>
					<i class="fa-solid fa-user"></i>&nbsp;
				</button>
			</a>
		</div>

		<div class="contenedor-botones-3">
			<a href="view_cart">
				<button type="submit">

					<i class="fa-solid fa-cart-shopping"></i>

				</button>

			</a>
		</div>

	</header>
</c:if>


<c:if test="${loggedCustomer!=null}">
	<!-- Si el usuario está logeado se muestra este menú -->

	<header class="header-logeado">
		<div class="contenedor-logo">
			<a href="${pageContext.request.contextPath}/"> <img
				src="./images/logo.png"
				width="120" height="80">
			</a>
		</div>
		<div class="contenedor-buscador-logueado">

			<form action="search" method="get" class="search-bar">
				<input type="text" placeholder="Busca en LVCVSGAMES">
				<button type="submit" value="Search">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>

		<div class="contenedor-botones-1-logueado">
			<a href="view_profile">
				<button type="submit">
				<i class="fa-solid fa-user"></i>
				</button>
			${loggedCustomer.nombrecompleto }
			</a>
		</div>

		<div class="contenedor-botones-2-logueado">
			<a href="view_orders">
				<button>
					<i class="fa-solid fa-file-lines"></i>
				</button>
			</a>
		</div>

		<div class="contenedor-botones-3-logueado">
			<a href="view_cart">
				<button type="submit">

					<i class="fa-solid fa-cart-shopping"></i>

				</button>

			</a>
		</div>

		<div class="contenedor-botones-4-logueado">
			<a href="logout">
				<button type="submit">
					<i class="fa-solid fa-arrow-right-from-bracket"></i>
				</button>

			</a>
		</div>

	</header>

</c:if>



<div>
	<c:forEach var="categoria" items="${listaCategoria }">
		<a href="view_category?id=${categoria.categoriaId }"> <b></b> <c:out
				value="${categoria.nombre }" /> |
		</a>
		<c:if test="${not status.last }">
			&nbsp; | &nbsp;
			</c:if>
	</c:forEach>
	&nbsp; &nbsp;
</div>


