package com.videojuegoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.videojuegoshop.enitity.Usuarios;

public class UsuarioDAO extends JpaDAO<Usuarios> implements GenericDAO<Usuarios> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);

	}

	public Usuarios create(Usuarios usuario) {
		return super.create(usuario);
	}

	@Override
	public Usuarios update(Usuarios usuario) {

		return super.update(usuario);
	}

	@Override
	public Usuarios get(Object usuarioId) {
		return super.find(Usuarios.class, usuarioId);
	}

	@Override
	public void delete(Object usuarioId) {
		super.delete(Usuarios.class, usuarioId);
	}

	@Override
	public List<Usuarios> listAll() {
		return super.findWithNamedQuery("Usuarios.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Usuarios.countAll");
	}

}
