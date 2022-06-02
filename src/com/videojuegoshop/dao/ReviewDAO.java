package com.videojuegoshop.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.videojuegoshop.enitity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {

		review.setReviewFecha(new Date());
		return super.create(review);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}
	
	public Review findByCustomerAndBook(Integer clienteId, Integer videojuegoId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("clienteId", clienteId);
		parameters.put("videojuegoId", videojuegoId);
		
		List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndVideogame", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}

}
