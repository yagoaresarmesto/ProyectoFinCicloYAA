package com.videojuegoshop.frontend.compracarrito;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clear_cart")
public class ClearCartServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public ClearCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarritoCompras carrito = (CarritoCompras) request.getSession().getAttribute("carrito");
		carrito.clear();

		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
