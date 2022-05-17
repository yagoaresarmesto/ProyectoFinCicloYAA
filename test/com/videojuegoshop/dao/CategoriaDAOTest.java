package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Categoria;

public class CategoriaDAOTest {

	private static CategoriaDAO categoriaDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		categoriaDao = new CategoriaDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoriaDao.close();
	}

	@Test
	public void testCreateCategoria() {
		Categoria newCat = new Categoria("Multijugador Masivo");
		Categoria categoria = categoriaDao.create(newCat);

		assertTrue(categoria != null && categoria.getCategoriaId() > 0);
	}

	@Test
	public void testUpdateCategoria() {
		Categoria cat = new Categoria("Shooter1");
		cat.setCategoriaId(1);

		Categoria categoria = categoriaDao.update(cat);

		assertEquals(cat.getNombre(), cat.getNombre());
	}

	@Test
	public void testGet() {
		Integer catId = 2;
		Categoria cat = categoriaDao.get(catId);

		assertNotNull(cat);
	}

	@Test
	public void testDeleteCategoria() {
		Integer catId = 7;
		categoriaDao.delete(catId);

		Categoria cat = categoriaDao.get(catId);

		assertNull(cat);
	}

	@Test
	public void testListAll() {
		List<Categoria> listaCategoria = categoriaDao.listAll();

		assertTrue(listaCategoria.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategoria = categoriaDao.count();

		assertTrue(totalCategoria > 0);

	}

	@Test
	public void tesdtFindByName() {
		String name = "Rpg";

		Categoria categoria = categoriaDao.findByName(name);

		assertNotNull(categoria);
	}

	@Test
	public void tesdtFindByNameNotFound() {
		String name = "Rpg12";

		Categoria categoria = categoriaDao.findByName(name);

		assertNull(categoria);
	}

}
