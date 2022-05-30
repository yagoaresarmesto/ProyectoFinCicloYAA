package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.PedidosDAO;
import com.videojuegoshop.enitity.VideojuegoPedido;

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

	public void viewOrderDetailForAdmin() throws ServletException, IOException{
		int pedidoId = Integer.parseInt(request.getParameter("id"));
		
		VideojuegoPedido pedido = pedidoDao.get(pedidoId );
		request.setAttribute("pedido", pedido);
		
		String detailPage = "order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);		
		
	}
}
