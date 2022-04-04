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
	public Usuarios update(Usuarios t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios delete(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
