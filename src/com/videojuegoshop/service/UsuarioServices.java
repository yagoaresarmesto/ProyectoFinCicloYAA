package com.videojuegoshop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.videojuegoshop.dao.UsuarioDAO;
import com.videojuegoshop.enitity.Usuarios;

public class UsuarioServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UsuarioDAO usuarioDAO;

	public UsuarioServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("PFCYAA");
		entityManager = entityManagerFactory.createEntityManager();
		usuarioDAO = new UsuarioDAO(entityManager);
	}

	public List<Usuarios>listUser() {
		List<Usuarios> listaUsuarios = usuarioDAO.listAll();
		
		return listaUsuarios;
	}
}
