package com.videojuegoshop.frontend.compracarrito;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCartServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] arrayVideojuegoIds = request.getParameterValues("videojuegoId");
		String[] arrayQuantities = new String[arrayVideojuegoIds.length];

		for (int i = 1; i <= arrayQuantities.length; i++) {
			String aQuantity = request.getParameter("quantity" + i);
			arrayQuantities[i - 1] = aQuantity;
		}

		int[] videojuegoIds = Arrays.stream(arrayVideojuegoIds).mapToInt(Integer::parseInt).toArray();
		int[] quantities = Arrays.stream(arrayQuantities).mapToInt(Integer::parseInt).toArray();

		CarritoCompras carrito = (CarritoCompras) request.getSession().getAttribute("carrito");
		carrito.updateCart(videojuegoIds, quantities);

		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}
}
