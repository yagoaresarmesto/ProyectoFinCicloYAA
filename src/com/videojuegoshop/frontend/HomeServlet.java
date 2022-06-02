package com.videojuegoshop.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Categoria;
import com.videojuegoshop.enitity.Videojuego;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
		
		List<Videojuego> listaNuevosVideojuegos = videojuegoDAO.listNewVideojuegos();
		List<Videojuego> listVideojuegoMasVendidos = videojuegoDAO.listBestSellingVideogames();
		
		
        request.setAttribute("listaNuevosVideojuegos", listaNuevosVideojuegos);
        request.setAttribute("listVideojuegoMasVendidos", listVideojuegoMasVendidos);
        
		String homepage = "frontend/index.jsp"; // Redirección a la homePage
		RequestDispatcher dispacher = request.getRequestDispatcher(homepage);
		dispacher.forward(request, response);
	}

}
