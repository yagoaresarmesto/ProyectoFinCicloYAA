package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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
		Usuarios usuario1 = new Usuarios(null, null, null);
		usuario1.setEmail("papa2@gmail.com");
		usuario1.setApellidos("Jesus Ares Pardo");
		usuario1.setContraseña("todossomos4");

		usuario1 = usuarioDAO.create(usuario1);

		assertTrue(usuario1.getUsuarioId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsuariosFieldsNotSet() {
		Usuarios usuario1 = new Usuarios(null, null, null);

		usuario1 = usuarioDAO.create(usuario1);

	}

	@Test
	public void testUpdateUsuarios() {
		Usuarios usuario = new Usuarios(null, null, null);
		usuario.setUsuarioId(1);
		usuario.setEmail("yagofingoi12345@gmail.com");
		usuario.setApellidos("Yago nombre cambiado");
		usuario.setContraseña("saltamontes1234");

		usuario = usuarioDAO.update(usuario);
		String expected = "saltamotnes1234";
		String actual = usuario.getContraseña();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetUsersFound() {
		Integer usuarioId = 1;
		Usuarios usuario = usuarioDAO.get(usuarioId);
		if (usuario != null) {
			System.out.println(usuario.getEmail());
		}

		assertNotNull(usuario);
	}

	@Test
	public void testGetUsersNotFound() {
		Integer usuarioId = 99; // Obvimanete no tenemos un usuario con ese id
		Usuarios usuario = usuarioDAO.get(usuarioId);

		assertNull(usuario);
	}

	@Test
	public void testDeleteUsers() {
		Integer usuarioId = 10;
		usuarioDAO.delete(usuarioId);

		Usuarios usuario = usuarioDAO.get(usuarioId);

		assertNull(usuario);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer usuarioId = 99;
		usuarioDAO.delete(usuarioId);
	}

	@Test
	public void testListAll() {
		List<Usuarios> listaUsuarios = usuarioDAO.listAll();

		for (Usuarios usuario : listaUsuarios) {
			System.out.println(usuario.getEmail());
		}

		assertTrue(listaUsuarios.size() > 0);
	}

	@Test
	public void testCount() {
		long totalUsuarios = usuarioDAO.count();
		assertEquals(9, totalUsuarios);

	}

	@Test
	public void testFindByEmail() {
		String email = "yagofingoi12345@gmail.com";
		Usuarios usuario = usuarioDAO.findByEmail(email);
		
		assertNotNull(usuario);
		
	}

	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
