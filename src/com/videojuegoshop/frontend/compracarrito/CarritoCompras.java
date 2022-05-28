package com.videojuegoshop.frontend.compracarrito;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.videojuegoshop.enitity.Videojuego;

public class CarritoCompras {

	private Map<Videojuego, Integer> carrito = new HashMap<>();
	
	public void addItem(Videojuego videojuego) {
		if (carrito.containsKey(videojuego)) {
			Integer quantity = carrito.get(videojuego) + 1;
			carrito.put(videojuego, quantity);			
		} else {
			carrito.put(videojuego, 1);
		}
	}
	
	public void removeItem(Videojuego videojuego) {
		carrito.remove(videojuego);
	}
	
	public int getTotalQuantity() {
		int total = 0;
		
		Iterator<Videojuego> iterator = carrito.keySet().iterator();
		
		while (iterator.hasNext()) {
			Videojuego siguiente = iterator.next();
			Integer cantidad = carrito.get(siguiente);
			total += cantidad;
		}
		
		return total;
	}
	
	public float getTotalAmount() {
		float total = 0.0f;
		
		Iterator<Videojuego> iterator = carrito.keySet().iterator();
		
		while (iterator.hasNext()) {
			Videojuego videojuego = iterator.next();
			Integer cantidad = carrito.get(videojuego);
			double subTotal = cantidad * videojuego.getPrecio();
			total += subTotal;
		}		
		
		return total;
	}
	
	public void updateCart(int[] videojuegoIds, int[] quantities) {
		for (int i = 0; i < videojuegoIds.length; i++) {
			Videojuego key = new Videojuego(videojuegoIds[i]);
			Integer value = quantities[i];
			carrito.put(key, value);
		}
	}
	
	
	public void clear() {
		carrito.clear();
	}
	
	public int getTotalItems() {
		return carrito.size();
	}
	
	public Map<Videojuego, Integer> getItems() {
		return this.carrito;
	}
}
