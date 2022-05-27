package com.videojuegoshop.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.videojuegoshop.enitity.Review;
import com.videojuegoshop.enitity.Videojuego;

public class VideogameRatingTest {

	@Test
	public void testAverageRating() {

		Videojuego videojuego = new Videojuego();

		Set<Review> reviews = new HashSet<>();
		Review review1 = new Review();
		review1.setClasificacion(5);
		reviews.add(review1);

		videojuego.setReviews(reviews);

		float averageRating = videojuego.getAverageRating();

		assertEquals(5.0, averageRating, 0.0);

	}

	@Test
	public void testAverageRating2() {
		Videojuego videojuego = new Videojuego();

		float averageRating = videojuego.getAverageRating();

		assertEquals(0.0, averageRating, 0.0);
	}

	@Test
	public void testAverageRating3() {
		Videojuego videojuego = new Videojuego();

		Set<Review> reviews = new HashSet<>();
		Review review1 = new Review();
		review1.setClasificacion(5);
		reviews.add(review1);

		Review review2 = new Review();
		review2.setClasificacion(4);
		reviews.add(review2);

		Review review3 = new Review();
		review3.setClasificacion(3);
		reviews.add(review3);

		videojuego.setReviews(reviews);

		float averageRating = videojuego.getAverageRating();

		assertEquals(4.0, averageRating, 0.0);
	}

	@Test
	public void testRatingString1() {
		float averageRating = 0.0f;
		Videojuego videojuego = new Videojuego();
		String actual = videojuego.getRatingString(averageRating);

		String expected = "off,off,off,off,off";

		assertEquals(expected, actual);
	}

	@Test
	public void testRatingString2() {
		float averageRating = 5.0f;
		Videojuego videojuego = new Videojuego();
		String actual = videojuego.getRatingString(averageRating);

		String expected = "on,on,on,on,on";

		assertEquals(expected, actual);

	}


	@Test
	public void testRatingString3() {
		float averageRating = 3.0f;
		Videojuego videojuego = new Videojuego();
		String actual = videojuego.getRatingString(averageRating);

		String expected = "on,on,on,off,off";

		assertEquals(expected, actual);
	}

	@Test
	public void testRatingString4() {
		float averageRating = 4.5f;
		Videojuego videojuego = new Videojuego();
		String actual = videojuego.getRatingString(averageRating);

		String expected = "on,on,on,on,half";

		assertEquals(expected, actual);
	}

	@Test
	public void testRatingString5() {
		float averageRating = 3.6f;
		Videojuego videojuego = new Videojuego();
		String actual = videojuego.getRatingString(averageRating);

		String expected = "on,on,on,half,off";

		assertEquals(expected, actual);
	}

}
