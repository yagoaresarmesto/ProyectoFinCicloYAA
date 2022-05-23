package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.ReviewDAO;
import com.videojuegoshop.enitity.Review;

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

		String message = "Review actualizada con �xito.";

		listAllReview(message);
	}

	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		reviewDAO.delete(reviewId);
		
		String message = "La review ha sido eliminada con �xito.";
		
		listAllReview(message);
		
	}

}
