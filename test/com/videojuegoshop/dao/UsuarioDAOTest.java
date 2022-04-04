package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Usuarios;

public class UsuarioDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UsuarioDAO usuarioDAO;

	@BeforeClass
	public static void setUpClass() {

		entityManagerFactory = Persistence.createEntityManagerFactory("PFCYAA");
		entityManager = entityManagerFactory.createEntityManager();

		usuarioDAO = new UsuarioDAO(entityManager);
	}

	@Test
	public void testCreateUsuarios() {
		Usuarios usuario1 = new Usuarios();
		usuario1.setEmail("papa2@gmail.com");
		usuario1.setApellidos("Jesus Ares Pardo");
		usuario1.setContraseña("todossomos4");

		usuario1 = usuarioDAO.create(usuario1);

		assertTrue(usuario1.getUsuarioId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsuariosFieldsNotSet() {
		Usuarios usuario1 = new Usuarios();

		usuario1 = usuarioDAO.create(usuario1);

	}

	@Test
	public void testUpdateUsuarios() {
		Usuarios usuario = new Usuarios();
		usuario.setUsuarioId(1);
		usuario.setEmail("yagofingoi12345@gmail.com");
		usuario.setApellidos("Yago nombre cambiado");
		usuario.setContraseña("saltamontes1234");

		usuario = usuarioDAO.update(usuario);
		String expected = "saltamotnes1234";
		String actual = usuario.getContraseña();

		assertEquals(expected, actual);
	}

	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
