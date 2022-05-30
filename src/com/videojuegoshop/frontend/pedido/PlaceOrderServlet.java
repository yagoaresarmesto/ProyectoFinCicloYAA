package com.videojuegoshop.frontend.pedido;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.service.PedidoServices;

@WebServlet("/place_order")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlaceOrderServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PedidoServices pedidoServices = new PedidoServices(request, response);
		pedidoServices.placeOrder();
	}

}
