package com.videojuegoshop.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.videojuegoshop.enitity.Videojuego;

public class VideojuegoDAO extends JpaDAO<Videojuego> implements GenericDAO<Videojuego> {

	public VideojuegoDAO(EntityManager entityManager) {
		super(entityManager);

	}

	@Override
	public Videojuego create(Videojuego videojuego) {
		videojuego.setFechaActualizacion(new Date());
		return super.create(videojuego);
	}

	@Override
	public Videojuego update(Videojuego videojuego) {
		videojuego.setFechaActualizacion(new Date());
		return super.update(videojuego);
	}

	@Override
	public Videojuego get(Object videojuegoId) {

		return super.find(Videojuego.class, videojuegoId);
	}

	@Override
	public void delete(Object videojuegoId) {
		super.delete(Videojuego.class, videojuegoId);
	}

	@Override
	public List<Videojuego> listAll() {

		return super.findWithNamedQuery("Videojuego.findAll");
	}

	public Videojuego findByTitle(String titulo) {

		List<Videojuego> resultado = super.findWithNamedQuery("Videojuego.findByTitle", "titulo", titulo);

		if (!resultado.isEmpty()) {
			return resultado.get(0);
		}
		return null;

	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Videojuego.countAll");
	}

}
