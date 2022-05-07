package com.videojuegoshop.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.enitity.Categoria;

@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		List<Categoria> listaCategoria = categoriaDAO.listAll();
		request.setAttribute("listaCategoria", listaCategoria);

		String homepage = "frontend/index.jsp"; // Redirección a la homePage
		RequestDispatcher dispacher = request.getRequestDispatcher(homepage);
		dispacher.forward(request, response);
	}

}
