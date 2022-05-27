package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.videojuegoshop.dao.ReviewDAO;
import com.videojuegoshop.dao.VideojuegoDAO;
import com.videojuegoshop.enitity.Cliente;
import com.videojuegoshop.enitity.Review;
import com.videojuegoshop.enitity.Videojuego;

public class ReviewServices {

	private ReviewDAO reviewDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.reviewDAO = new ReviewDAO();

	}

	public void listAllReview() throws ServletException, IOException {

		listAllReview(null);
	}

	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> listaReviews = reviewDAO.listAll();

		request.setAttribute("listaReviews", listaReviews);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "review_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);

	}

	public void editReview() throws ServletException, IOException {

		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);

		request.setAttribute("review", review);

		String editPage = "review_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);

	}

	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String encabezado = request.getParameter("encabezado");
		String comentario = request.getParameter("comentario");

		Review review = reviewDAO.get(reviewId);
		review.setEncabezado(encabezado);
		review.setComentario(comentario);

		reviewDAO.update(review);

		String message = "Review actualizada con éxito.";

		listAllReview(message);
	}

	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		reviewDAO.delete(reviewId);

		String message = "La review ha sido eliminada con éxito.";

		listAllReview(message);

	}

	public void showReviewForm() throws ServletException, IOException {
		Integer videojuegoId = Integer.parseInt(request.getParameter("videogame_id"));
		VideojuegoDAO videojuegoDao = new VideojuegoDAO();
		Videojuego videojuego = videojuegoDao.get(videojuegoId);

		HttpSession session = request.getSession();

		Cliente cliente = (Cliente) session.getAttribute("loggedCustomer");

		Review existReview = reviewDAO.findByCustomerAndBook(cliente.getClienteId(), videojuegoId);

		session.setAttribute("videojuego", videojuego);

		String targetPage = "frontend/review_form.jsp";

		if (existReview != null) {
			request.setAttribute("review", existReview);
			targetPage = "frontend/review_info.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
		dispatcher.forward(request, response);

	}

	public void submitReview() throws ServletException, IOException {
		Integer videojuegoId = Integer.parseInt(request.getParameter("videojuegoId"));
		Integer clasificacion = Integer.parseInt(request.getParameter("rating"));
		String encabezado = request.getParameter("encabezado");
		String comentario = request.getParameter("comentario");

		Review nuevaReview = new Review();
		nuevaReview.setEncabezado(encabezado);
		nuevaReview.setComentario(comentario);
		nuevaReview.setClasificacion(clasificacion);

		Videojuego videojuego = new Videojuego();
		videojuego.setVideojuegoId(videojuegoId);
		;
		nuevaReview.setVideojuego(videojuego);

		Cliente cliente = (Cliente) request.getSession().getAttribute("loggedCustomer");
		nuevaReview.setCliente(cliente);

		reviewDAO.create(nuevaReview);

		String messagePage = "frontend/review_done.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);

	}

}
