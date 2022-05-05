package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.enitity.Categoria;

public class CategoriaServices {

	
	private EntityManager entityManager;
	private CategoriaDAO categoriaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public CategoriaServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		
		categoriaDAO = new CategoriaDAO(entityManager);
	}
	
	public void listCategory() throws ServletException, IOException {
		List<Categoria> listaCategoria = categoriaDAO.listAll();
		
		request.setAttribute("listaCategoria", listaCategoria);
		
		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		
		requestDispatcher.forward(request, response);

	}
	
}
