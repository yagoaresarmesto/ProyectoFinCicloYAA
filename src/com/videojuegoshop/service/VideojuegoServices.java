package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Categoria;
import com.videojuegoshop.enitity.Videojuego;

public class VideojuegoServices {
	private EntityManager entityManager;
	private VideojuegoDAO videojuegoDAO;
	private CategoriaDAO categoriaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public VideojuegoServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		videojuegoDAO = new VideojuegoDAO(entityManager);
		categoriaDAO = new CategoriaDAO(entityManager);
	}

	public void listarVideojuegos() throws ServletException, IOException {
		List<Videojuego> listaVideojuegos = videojuegoDAO.listAll();
		request.setAttribute("listaVideojuegos", listaVideojuegos);

		String listPage = "videogame_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}
	
	public void showVideojuegoForm() throws ServletException, IOException {
		
		List<Categoria> listaCategoria = categoriaDAO.listAll();
		request.setAttribute("listaCategoria", listaCategoria);
		
		String newPage = "videogame_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);		
	}

}
