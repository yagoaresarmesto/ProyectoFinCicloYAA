package com.videojuegoshop.frontend.compracarrito;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.enitity.Videojuego;

@WebServlet("/remove_from_cart")
public class RemoveVideogameFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveVideogameFromCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer videojuegoId = Integer.parseInt(request.getParameter("videogame_id"));

		Object carritoObject = request.getSession().getAttribute("carrito");

		CarritoCompras carritoCompras = (CarritoCompras) carritoObject;

		carritoCompras.removeItem(new Videojuego(videojuegoId));

		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
