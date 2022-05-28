package com.videojuegoshop.frontend.compracarrito;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Videojuego;

@WebServlet("/add_to_cart")
public class AddVideogameToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVideogameToCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer videojuegoId = Integer.parseInt(request.getParameter("videogame_id"));
	
		Object carritoObject = request.getSession().getAttribute("carrito");

		CarritoCompras carritoCompras = null;

		if (carritoObject != null && carritoObject instanceof CarritoCompras) {
			carritoCompras = (CarritoCompras) carritoObject;
		} else {
			carritoCompras = new CarritoCompras();
			request.getSession().setAttribute("carrito", carritoCompras);
		}

		VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
		Videojuego videojuego = videojuegoDAO.get(videojuegoId);

		carritoCompras.addItem(videojuego);

		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);

	}

}
