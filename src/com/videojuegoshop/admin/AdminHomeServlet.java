package com.videojuegoshop.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.ClienteDAO;
import com.videojuegoshop.dao.PedidosDAO;
import com.videojuegoshop.dao.ReviewDAO;
import com.videojuegoshop.dao.UsuarioDAO;
import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.VideojuegoPedido;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHomeServlet() {
		super();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO usuarioDao = new UsuarioDAO();
		PedidosDAO pedidoDao = new PedidosDAO();
		ReviewDAO reviewDAO = new ReviewDAO();
		VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		
		List<VideojuegoPedido> listaVentasRecientes = pedidoDao.listMostRecentSales();

		long totalUsuarios = usuarioDao.count();
		long totalVideojuegos = videojuegoDAO.count();
		long totalClientes = clienteDAO.count();
		long totalReviews = reviewDAO.count();
		long totalPedidos = pedidoDao.count();
		
		request.setAttribute("listaVentasRecientes", listaVentasRecientes);
		request.setAttribute("totalUsuarios", totalUsuarios);
		request.setAttribute("totalVideojuegos", totalVideojuegos);
		request.setAttribute("totalClientes", totalClientes);
		request.setAttribute("totalReviews", totalReviews);
		request.setAttribute("totalPedidos", totalPedidos);
		
		String homepage = "index.jsp"; // Redirección a la homePage
		RequestDispatcher dispacher = request.getRequestDispatcher(homepage);
		dispacher.forward(request, response);
	}

}
