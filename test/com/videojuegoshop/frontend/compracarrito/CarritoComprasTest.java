package com.videojuegoshop.frontend.compracarrito;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Videojuego;

public class CarritoComprasTest {
	private static CarritoCompras carrito;

	@BeforeClass
	public static void SelectBeforeClass() throws Exception {
	    carrito = new CarritoCompras();
		Videojuego videojuego = new Videojuego(1);
		videojuego.setPrecio(10);
	
		carrito.addItem(videojuego);
		carrito.addItem(videojuego);
	}

	@Test
	public void testAddItem() {
	
		
		Map<Videojuego, Integer> items = carrito.getItems();
		int cantidad = items.get(new Videojuego(1));

		assertEquals(2, cantidad);
	}
	
	@Test
	public void testRemoveItem() {
		carrito.removeItem(new Videojuego(1));
		
		assertTrue(carrito.getItems().isEmpty());
	}
	
	@Test
	public void testRemoveItem2() {
		Videojuego videojuego2 = new Videojuego(2);
		carrito.addItem(videojuego2);
		
		carrito.removeItem(new Videojuego(2));
		
		assertNull(carrito.getItems().get(videojuego2));
	}	
	
	@Test
	public void testGetTotalQuantity() {
		Videojuego videojuego3 = new Videojuego(3);
		carrito.addItem(videojuego3);
		carrito.addItem(videojuego3);
		carrito.addItem(videojuego3);
		
		assertEquals(5, carrito.getTotalQuantity());
	}
	
	@Test
	public void testGetTotalAmount1() {
		CarritoCompras carrito = new CarritoCompras();
		assertEquals(0.0f, carrito.getTotalAmount(), 0.0f);
	}

	@Test
	public void testGetTotalAmount2() {		
		assertEquals(20.0f, carrito.getTotalAmount(), 0.0f); //Como hay 2 es 2*10, para acordarme
	}	
	
	
	@Test
	public void testClear() {
		carrito.clear();
		
		assertEquals(0, carrito.getTotalQuantity());
	}
	

}
