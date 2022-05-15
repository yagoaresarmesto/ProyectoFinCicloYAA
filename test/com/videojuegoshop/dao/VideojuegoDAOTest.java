package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Categoria;
import com.videojuegoshop.enitity.Videojuego;

public class VideojuegoDAOTest extends BaseDAOTest {

	private static VideojuegoDAO videojuegoDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		videojuegoDao = new VideojuegoDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateVideojuego() throws ParseException, IOException {
		Videojuego newVideojuego = new Videojuego();

		Categoria categoria = new Categoria("Rpg");
		categoria.setCategoriaId(4);
		newVideojuego.setCategoria(categoria);

		newVideojuego.setTitulo("Diablo2");
		newVideojuego.setCompañia("Activision-Blizzard");
		newVideojuego.setDescripcion("Muy chulo");
		newVideojuego.setPrecio(10.99f);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date fechaPublicacion = dateFormat.parse("06/29/2000");
		newVideojuego.setFechaPublicacion(fechaPublicacion);

		String imagePath = "D:\\ImagenesProeyctoFinCiclo\\diablo2.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newVideojuego.setImagen(imageBytes);

		Videojuego createdVideojuego = videojuegoDao.create(newVideojuego);

		assertTrue(createdVideojuego.getVideojuegoId() > 0);

	}

	@Test
	public void testCreate2ndVideojuego() throws ParseException, IOException {
		Videojuego newVideojuego = new Videojuego();

		Categoria categoria = new Categoria("Plataforma");
		categoria.setCategoriaId(6);
		newVideojuego.setCategoria(categoria);

		newVideojuego.setTitulo("New Super Mario Bros Wii");
		newVideojuego.setCompañia("Nintendo");
		newVideojuego.setDescripcion("Wapo");
		newVideojuego.setPrecio(10.99f);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date fechaPublicacion = dateFormat.parse("11/12/2009");
		newVideojuego.setFechaPublicacion(fechaPublicacion);

		String imagePath = "D:\\ImagenesProeyctoFinCiclo\\MarioBros.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newVideojuego.setImagen(imageBytes);

		Videojuego createdVideojuego = videojuegoDao.create(newVideojuego);

		assertTrue(createdVideojuego.getVideojuegoId() > 0);

	}

	@Test
	public void testUpdateVideojuego() throws ParseException, IOException {
		Videojuego existVideojuego = new Videojuego();
		existVideojuego.setVideojuegoId(9);

		Categoria categoria = new Categoria("Rpg");
		categoria.setCategoriaId(4);
		existVideojuego.setCategoria(categoria);

		existVideojuego.setTitulo("Diablo2 Resurrected");
		existVideojuego.setCompañia("Activision-Blizzard");
		existVideojuego.setDescripcion("Muy chulo");
		existVideojuego.setPrecio(20f);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date fechaPublicacion = dateFormat.parse("06/29/2000");
		existVideojuego.setFechaPublicacion(fechaPublicacion);

		String imagePath = "D:\\ImagenesProeyctoFinCiclo\\diablo2.jpg";

		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existVideojuego.setImagen(imageBytes);

		Videojuego updatedVideojuego = videojuegoDao.update(existVideojuego);

		assertEquals(updatedVideojuego.getTitulo(), "Diablo2 Resurrected");

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteVideojuegoFail() {
		Integer videojuegoId = 100;
		videojuegoDao.delete(videojuegoId);

	}

	@Test
	public void testDeleteVideojuegoSuccess() {
		Integer videojuegoId = 8;
		videojuegoDao.delete(videojuegoId);
		assertTrue(true);
	}

	@Test
	public void testGetVideojuegoFail() {
		Integer videojuegoId = 99;
		Videojuego videojuego = videojuegoDao.get(videojuegoId);

		assertNull(videojuego);
	}

	@Test
	public void testGetVideojuegoSuccess() {
		Integer videojuegoId = 9;
		Videojuego videojuego = videojuegoDao.get(videojuegoId);

		assertNotNull(videojuego);
	}

	@Test
	public void testListAll() {
		List<Videojuego> listarVideojuego = videojuegoDao.listAll();

		for (Videojuego aVideojuego : listarVideojuego) {
			System.out.println(aVideojuego.getTitulo() + " - " + aVideojuego.getCompañia());
		}

		assertFalse(listarVideojuego.isEmpty());
	}

	@Test
	public void testFindByTitleNotExist() {
		String titulo = "Hola";
		Videojuego videojuego = videojuegoDao.findByTitle(titulo);
		
		assertNull(videojuego);
	}

	
	@Test
	public void testFindByTitleExist() {
		String titulo = "Diablo2";
		Videojuego videojuego = videojuegoDao.findByTitle(titulo);
		
		System.out.println(videojuego.getCompañia());
		System.out.println(videojuego.getPrecio());
		assertNotNull(videojuego);
	}
	
	@Test
	public void testCount() {
		long totalVideojuegos = videojuegoDao.count();
		
		assertEquals(2, totalVideojuegos);
	}
	
	@Test
	public void testListNewVideogame() {
	List<Videojuego> listaNuevosVideojuegos = videojuegoDao.listNewVideojuegos();
	for(Videojuego aVideojuego : listaNuevosVideojuegos) {
		System.out.println(aVideojuego.getTitulo() +" - "+ aVideojuego.getFechaPublicacion());
	}
	assertEquals(4, listaNuevosVideojuegos.size());
	}
	
	
	@Test
	public void listByCategory(){
		int categoriaId = 4;
		
		List<Videojuego> listaVideojuegos = videojuegoDao.listarByCategoria(categoriaId);
		
		assertTrue(listaVideojuegos.size()>0);
		
	}
}
