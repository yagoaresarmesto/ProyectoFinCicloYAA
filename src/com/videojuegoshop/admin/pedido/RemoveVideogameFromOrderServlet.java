package com.videojuegoshop.admin.pedido;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.videojuegoshop.enitity.VideojuegoPedido;
import com.videojuegoshop.enitity.DetallesPedido;

@WebServlet("/admin/remove_videogame_from_order")
public class RemoveVideogameFromOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveVideogameFromOrderServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int videojuegoId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		VideojuegoPedido pedido = (VideojuegoPedido) session.getAttribute("pedido");

		Set<DetallesPedido> pedidoDetalles = pedido.getDetallesPedidos();
		Iterator<DetallesPedido> iterator = pedidoDetalles.iterator();
		
		while (iterator.hasNext()) {
			DetallesPedido pedidoDetalle = iterator.next();
			
			if (pedidoDetalle.getVideojuego().getVideojuegoId()== videojuegoId) {
				float nuevoTotal = pedido.getTotal() - pedidoDetalle.getSubtotal();
				pedido.setTotal(nuevoTotal);
				iterator.remove();
			}			
		}
		
		String editOrderFormPage = "order_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editOrderFormPage);
		dispatcher.forward(request, response);
	}

}
