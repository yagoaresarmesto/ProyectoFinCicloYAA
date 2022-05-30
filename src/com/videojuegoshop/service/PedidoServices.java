package com.videojuegoshop.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.videojuegoshop.dao.PedidosDAO;
import com.videojuegoshop.enitity.Cliente;
import com.videojuegoshop.enitity.DetallesPedido;
import com.videojuegoshop.enitity.Videojuego;
import com.videojuegoshop.enitity.VideojuegoPedido;
import com.videojuegoshop.frontend.compracarrito.CarritoCompras;

public class PedidoServices {

	private PedidosDAO pedidoDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public PedidoServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.pedidoDao = new PedidosDAO();
	}

	public void listAllOrder() throws ServletException, IOException {
		List<VideojuegoPedido> listaPedido = pedidoDao.listAll();

		request.setAttribute("listaPedido", listaPedido);
		String listPage = "order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int pedidoId = Integer.parseInt(request.getParameter("id"));

		VideojuegoPedido pedido = pedidoDao.get(pedidoId);
		request.setAttribute("pedido", pedido);

		String detailPage = "order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);

	}

	public void showCheckoutForm() throws ServletException, IOException {
		String checkOutPage = "frontend/checkout.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkOutPage);
		dispatcher.forward(request, response);

	}

	public void placeOrder() throws ServletException, IOException {

		String destinatarioNombre = request.getParameter("nombreDestinatario");
		String destinatarioTelefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String codigoPostal = request.getParameter("codigoPostal");
		String pais = request.getParameter("pais");
		String metodoPago = request.getParameter("paymentMethod");
		String direccionEnvio = direccion + ", " + ciudad + ", " + codigoPostal + ", " + pais;

		VideojuegoPedido pedido = new VideojuegoPedido();
		pedido.setNombreDestinatario(destinatarioNombre);
		pedido.setTelefonoDestinatario(destinatarioTelefono);
		pedido.setDireccionEnvio(direccionEnvio);
		pedido.setMetodoPago(metodoPago);

		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("loggedCustomer");
		pedido.setCliente(cliente);

		CarritoCompras carritoCompras = (CarritoCompras) session.getAttribute("carrito");
		Map<Videojuego, Integer> items = carritoCompras.getItems();

		Iterator<Videojuego> iterator = items.keySet().iterator();

		Set<DetallesPedido> pedidoDetalles = new HashSet<>();

		while (iterator.hasNext()) {
			Videojuego videojuego = iterator.next();
			Integer cantidad = items.get(videojuego);
			float subtotal = cantidad * videojuego.getPrecio();

			DetallesPedido pedidoDetalle = new DetallesPedido();
			pedidoDetalle.setVideojuego(videojuego);
			pedidoDetalle.setVideojuegoPedido(pedido);
			pedidoDetalle.setCantidad(cantidad);
			pedidoDetalle.setSubtotal(subtotal);

			pedidoDetalles.add(pedidoDetalle);

		}

		pedido.setDetallesPedidos(pedidoDetalles);
		pedido.setTotal(carritoCompras.getTotalAmount());

		pedidoDao.create(pedido);
		carritoCompras.clear();

		String message = "Gracias, tu pedido ha sido recibido. " + "El pedido te llegará en unos días.";
		request.setAttribute("message", message);
		String messagePage = "frontend/message.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("loggedCustomer");
		List<VideojuegoPedido> listaPedidos = pedidoDao.listByCustomer(cliente.getClienteId());

		request.setAttribute("listaPedidos", listaPedidos);

		String historyPage = "frontend/order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(historyPage);
		dispatcher.forward(request, response);

	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {

		int pedidoId = Integer.parseInt(request.getParameter("id"));

		VideojuegoPedido pedido = pedidoDao.get(pedidoId);
		request.setAttribute("pedido", pedido);

		String detailPage = "frontend/order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);

	}
}
