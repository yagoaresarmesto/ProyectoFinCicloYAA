package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Cliente;
import com.videojuegoshop.enitity.Review;
import com.videojuegoshop.enitity.Videojuego;

public class ReviewDAOTest {

	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();

	}

	@Test
	public void testCreateReview() {

		Review review = new Review();
		Videojuego videojuego = new Videojuego();
		videojuego.setVideojuegoId(10);

		Cliente cliente = new Cliente();
		cliente.setClienteId(5);

		review.setVideojuego(videojuego);
		review.setCliente(cliente);

		review.setEncabezado("Esta entretenido");
		review.setClasificacion(4);
		review.setComentario("Para pasar el rato con los colegas");

		Review guardadaReview = reviewDao.create(review);

		assertTrue(guardadaReview.getReviewId() > 0);
	}

	@Test
	public void testGet() {
		Integer reviewId = 1;
		Review review = reviewDao.get(reviewId);

		assertNotNull(review);
	}

	@Test
	public void testUpdateReview() {
		Integer reviewId = 1;
		Review review = reviewDao.get(reviewId);

		review.setEncabezado("Bastante bueno");

		Review updatedReview = reviewDao.update(review);

		assertEquals(review.getEncabezado(), updatedReview.getEncabezado());
	}

	@Test
	public void testDeleteReview() {
		int reviewId = 2;
		reviewDao.delete(reviewId);
		
		Review review = reviewDao.get(reviewId);
		
		assertNull(review);
	}

	@Test
	public void testListAll() {
		List<Review> listReview = reviewDao.listAll();

		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCount() {
		Long totalReviews = reviewDao.count();
		System.out.println("Review totales: " + totalReviews);
		assertTrue(totalReviews > 0);
	}

}
