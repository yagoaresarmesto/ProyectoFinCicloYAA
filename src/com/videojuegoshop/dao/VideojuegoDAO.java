package com.videojuegoshop.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.videojuegoshop.enitity.Videojuego;

public class VideojuegoDAO extends JpaDAO<Videojuego> implements GenericDAO<Videojuego> {

	public VideojuegoDAO() {
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

	public List<Videojuego> listarByCategoria(int categoriaId) {

		return super.findWithNamedQuery("Videojuego.findByCategory", "catId", categoriaId);

	}

	public List<Videojuego> search(String keyword) {
		return super.findWithNamedQuery("Videojuego.search", "keyword", keyword);
	}

	public List<Videojuego> listNewVideojuegos() {

		return super.findWithNamedQuery("Videojuego.listNew", 0, 4);

	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Videojuego.countAll");
	}

	public long countByCategory(int categoriaId) {
		return super.countWithNamedQuery("Videojuego.countByCategory", "catId", categoriaId);
	}
}
