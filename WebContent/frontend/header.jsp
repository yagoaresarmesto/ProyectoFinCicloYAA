<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header">
	<div class="contenedor-logo">
		<a href="${pageContext.request.contextPath}/"> <img
			src="https://cdn.pccomponentes.com/img/logos/logo-pccomponentes.svg"
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
	<c:if test="${loggedCustomer==null}">
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
					<i class="fa-solid fa-user"></i></i>&nbsp;
				</button>
			</a>
		</div>
	</c:if>

	<c:if test="${loggedCustomer!=null}">
		<a href="view_profile">Bienvenido, ${loggedCustomer.nombrecompleto }
		</a>
		<a href="view_orders"> VP</a>
		<a href="logout"> CS</a>
	
	</c:if>



	

	<div class="contenedor-botones-3">
		<a href="view_cart">
			<button type="submit">

				<i class="fa-solid fa-cart-shopping"></i>

			</button>
		</a>
	</div>
</header>


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


