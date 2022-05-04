package com.videojuegoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.videojuegoshop.enitity.Categoria;

public class CategoriaDAO extends JpaDAO<Categoria> implements GenericDAO<Categoria> {

	public CategoriaDAO(EntityManager entityManager) {
		super(entityManager);
	
	}

	@Override
	public Categoria create(Categoria categoria) {
		return super.create(categoria);
	}

	@Override
	public Categoria update(Categoria categoria) {
		return super.update(categoria);
	
	}

	@Override
	public Categoria get(Object id) {
		return super.find(Categoria.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Categoria.class, id);	
	}

	@Override
	public List<Categoria> listAll() {
		return super.findWithNamedQuery("Categoria.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Categoria.countAll");
	}

}
