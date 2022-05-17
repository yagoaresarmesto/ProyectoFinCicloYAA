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

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.enitity.Categoria;

public class CategoriaServices {

	private CategoriaDAO categoriaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoriaServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		

		categoriaDAO = new CategoriaDAO();
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Categoria> listaCategoria = categoriaDAO.listAll();

		request.setAttribute("listaCategoria", listaCategoria);
		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("nombre");
		Categoria existCategory = categoriaDAO.findByName(name);

		if (existCategory != null) {
			String message = "No se pudo crear la categoría. " + "Una categoría con nombre " + name + " ya existe";
			request.setAttribute("message", message);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Categoria newCategory = new Categoria(name);
			categoriaDAO.create(newCategory);
			String message = "Nueva categoria creada con éxito";
			listCategory(message);
		}
	}

	public void editCategory() throws ServletException, IOException {
		int categoriaId = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = categoriaDAO.get(categoriaId);
		request.setAttribute("categoria", categoria);

		String editPage = "category_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
		String categoriaNombre = request.getParameter("nombre");

		Categoria categoryById = categoriaDAO.get(categoriaId);
		Categoria categoryByName = categoriaDAO.findByName(categoriaNombre);

		if (categoryByName != null && categoryById.getCategoriaId() != categoryByName.getCategoriaId()) {
			String message = "No se pudo actualizar la categoría." + " La categoría con nombre " + categoriaNombre
					+ " ya existe.";

			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			categoryById.setNombre(categoriaNombre);
			categoriaDAO.update(categoryById);
			String message = "Categoria se ha actualizado con éxito";
			listCategory(message);
		}

	}

	public void deleteCategory() throws ServletException, IOException {
		
		int categoriaId = Integer.parseInt(request.getParameter("id"));
		categoriaDAO.delete(categoriaId);
		String message = "La categoria con ID" + categoriaId + " ha sido eliminada con éxito";
		listCategory(message);

	}

}
