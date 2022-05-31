package com.videojuegoshop.admin.pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Videojuego;

@WebServlet("/admin/add_videogame_form")
public class ShowAddVideogameFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAddVideogameFormServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VideojuegoDAO videojuegoDao = new VideojuegoDAO();
		List<Videojuego> listaVideojuego = videojuegoDao.listAll();
		request.setAttribute("listaVideojuego", listaVideojuego);
		
		String addFormPage = "add_videogame_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(addFormPage);
		dispatcher.forward(request, response);
	}

}
