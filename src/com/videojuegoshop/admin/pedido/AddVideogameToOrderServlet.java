package com.videojuegoshop.admin.pedido;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.DetallesPedido;
import com.videojuegoshop.enitity.Videojuego;
import com.videojuegoshop.enitity.VideojuegoPedido;

@WebServlet("/admin/add_videogame_to_order")
public class AddVideogameToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVideogameToOrderServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int videojuegoId = Integer.parseInt(request.getParameter("videogameId"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
		Videojuego videojuego = videojuegoDAO.get(videojuegoId);
		
		HttpSession session = request.getSession();
		VideojuegoPedido pedido = (VideojuegoPedido) session.getAttribute("pedido");
		
		float subtotal = cantidad * videojuego.getPrecio();
		
		DetallesPedido pedidoDetalle = new DetallesPedido();
		pedidoDetalle.setVideojuego(videojuego);
		pedidoDetalle.setCantidad(cantidad);
		pedidoDetalle.setSubtotal(subtotal);
		
		float nuevoTotal = pedido.getTotal() + subtotal;
		pedido.setTotal(nuevoTotal);
		
		pedido.getDetallesPedidos().add(pedidoDetalle);
		
		request.setAttribute("videojuego", videojuego);
		session.setAttribute("NuevoVideojuegoPendienteDeAñadirPedido", true);
		
		String resultPage = "add_videogame_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}

}
