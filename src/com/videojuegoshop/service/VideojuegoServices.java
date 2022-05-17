package com.videojuegoshop.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Categoria;
import com.videojuegoshop.enitity.Videojuego;

import antlr.LexerSharedInputState;

public class VideojuegoServices {
	private VideojuegoDAO videojuegoDAO;
	private CategoriaDAO categoriaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public VideojuegoServices (HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		videojuegoDAO = new VideojuegoDAO();
		categoriaDAO = new CategoriaDAO();
	}

	public void listarVideojuegos() throws ServletException, IOException {
		listarVideojuegos(null);
	}

	public void listarVideojuegos(String message) throws ServletException, IOException {
		List<Videojuego> listaVideojuegos = videojuegoDAO.listAll();
		request.setAttribute("listaVideojuegos", listaVideojuegos);

		if (message != null) {
			request.setAttribute("message", message);
		}

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

	public void createVideojuego() throws ServletException, IOException {

		String titulo = request.getParameter("titulo");

		Videojuego existVideojuego = videojuegoDAO.findByTitle(titulo);

		if (existVideojuego != null) {
			String message = "No se pudo crear un vidoejeugo por que el titulo '" + titulo + "' ya existe";
			listarVideojuegos(message);
			return;
		}

		Videojuego newVideojuego = new Videojuego();
		readVideogame(newVideojuego);

		Videojuego createdVidejuego = videojuegoDAO.create(newVideojuego);

		if (createdVidejuego.getVideojuegoId() > 0) {
			String message = "Videojuego creado con éxito.";
			request.setAttribute("message", message);
			listarVideojuegos(message);
		}

	}

	public void readVideogame(Videojuego videojuego) throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String compañia = request.getParameter("compañia");
		String descripcion = request.getParameter("descripcion");
		float precio = Float.parseFloat(request.getParameter("precio"));

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date fechaPublicacion = null;

		try {
			fechaPublicacion = dateFormat.parse(request.getParameter("fechaLanzamiento"));
		} catch (ParseException ex) {
			ex.printStackTrace();
			throw new ServletException("Error al pasar formato (format is MM/dd/yyyy)");
		}

		videojuego.setTitulo(titulo);
		videojuego.setCompañia(compañia);
		videojuego.setDescripcion(descripcion);
		videojuego.setFechaPublicacion(fechaPublicacion);

		Integer categoriaId = Integer.parseInt(request.getParameter("categoria"));

		Categoria categoria = categoriaDAO.get(categoriaId);
		videojuego.setCategoria(categoria);

		videojuego.setPrecio(precio);

		Part part = request.getPart("videojuegoImagen");

		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];

			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();

			videojuego.setImagen(imageBytes);

		}
	}

	public void editVideogame() throws ServletException, IOException {

		Integer videojuegoId = Integer.parseInt(request.getParameter("id"));
		Videojuego videojuego = videojuegoDAO.get(videojuegoId);
		List<Categoria> listaCategoria = categoriaDAO.listAll();

		request.setAttribute("videojuego", videojuego);
		request.setAttribute("listaCategoria", listaCategoria);

		String editPage = "videogame_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateVideogame() throws ServletException, IOException {
		Integer videojuegoId = Integer.parseInt(request.getParameter("videojuegoId"));
		String titulo = request.getParameter("titulo");

		Videojuego existVideogame = videojuegoDAO.get(videojuegoId);
		Videojuego videojuegoByTitle = videojuegoDAO.findByTitle(titulo);

		if (videojuegoByTitle != null && !existVideogame.equals(videojuegoByTitle)) {
			String message = "No se puedo actualizar el videojuego, hay otro videojuego con ese titulo.";
			listarVideojuegos(message);
			return;
		}

		readVideogame(existVideogame);

		videojuegoDAO.update(existVideogame);

		String message = "The book has been updated successfully.";
		listarVideojuegos(message);
	}

	public void deleteVideogame() throws ServletException, IOException {
		Integer videojuegoId = Integer.parseInt(request.getParameter("id"));

		videojuegoDAO.delete(videojuegoId);

		String message = "Videojuego eliminado con éxito.";
		listarVideojuegos(message);

	}

	public void listVideogameByCategory() throws ServletException, IOException {

		int categoriaId = Integer.parseInt(request.getParameter("id"));
		List<Videojuego> listaVidejuegos = videojuegoDAO.listarByCategoria(categoriaId);
		Categoria categoria = categoriaDAO.get(categoriaId);
		List<Categoria> listaCategoria = categoriaDAO.listAll();

		request.setAttribute("listaCategoria", listaCategoria);
		request.setAttribute("listaVideojuegos", listaVidejuegos);
		request.setAttribute("categoria", categoria);

		String listPage = "frontend/videogames_list_by_category.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}

	public void viewVideogameDetail() throws ServletException, IOException {

		Integer videojuegoId = Integer.parseInt(request.getParameter("id"));
		Videojuego videojuego = videojuegoDAO.get(videojuegoId);

		request.setAttribute("videojuego", videojuego);

		String detailPage = "frontend/videogame_detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(detailPage);
		requestDispatcher.forward(request, response);
	}

	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Videojuego> result = null;

		if (keyword.equals("")) {
			result = videojuegoDAO.listAll();
		} else {
			result = videojuegoDAO.search(keyword);

		}
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("result", result);
		
		String resultPage = "frontend/search_result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
		requestDispatcher.forward(request, response);	
	}
}
