package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Cliente;
import com.videojuegoshop.enitity.VideojuegoPedido;
import com.videojuegoshop.enitity.DetallesPedido;
import com.videojuegoshop.enitity.Videojuego;

public class PedidosDAOTest {

	private static PedidosDAO pedidoDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pedidoDAO = new PedidosDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		pedidoDAO.close();
	}

	@Test
	public void testCreateVideojuegoPedido() {
		
		VideojuegoPedido pedido = new VideojuegoPedido();
		Cliente cliente = new Cliente();
		cliente.setClienteId(4);

		pedido.setCliente(cliente);
		pedido.setNombreDestinatario("Yago Ares Amresto");
		pedido.setTelefonoDestinatario("639010986");
		pedido.setDireccionEnvio("24 Obispo Aguirre, Lugo, España");

		Set<DetallesPedido> detallesPedidos = new HashSet<>();
		DetallesPedido detallePedido = new DetallesPedido();

		Videojuego videojuego = new Videojuego(9);
		detallePedido.setVideojuego(videojuego);
		detallePedido.setCantidad(2);
		detallePedido.setSubtotal(21.98f);
		detallePedido.setVideojuegoPedido(pedido);

		detallesPedidos.add(detallePedido);

		pedido.setDetallesPedidos(detallesPedidos);

		VideojuegoPedido pedidoGuardado = pedidoDAO.create(pedido);

		assertNotNull(pedidoGuardado);

	}

	@Test
	public void testCreateVideojuegoPedido2() {

		VideojuegoPedido pedido = new VideojuegoPedido();
		Cliente cliente = new Cliente();
		cliente.setClienteId(5);

		pedido.setCliente(cliente);
		pedido.setNombreDestinatario("Jesus Ares Armesto");
		pedido.setTelefonoDestinatario("639010986");
		pedido.setDireccionEnvio("24 Obispo Aguirre, Lugo, España");

		Set<DetallesPedido> detallesPedidos = new HashSet<>();
		DetallesPedido detallePedido1 = new DetallesPedido();

		Videojuego videojuego1 = new Videojuego(10);
		detallePedido1.setVideojuego(videojuego1);
		detallePedido1.setCantidad(2);
		detallePedido1.setSubtotal(21.98f);
		detallePedido1.setVideojuegoPedido(pedido);

		detallesPedidos.add(detallePedido1);

		Videojuego videojuego2 = new Videojuego(11);
		DetallesPedido detallePedido2 = new DetallesPedido();
		detallePedido2.setVideojuego(videojuego2);
		detallePedido2.setCantidad(1);
		detallePedido2.setSubtotal(50f);
		detallePedido2.setVideojuegoPedido(pedido);

		detallesPedidos.add(detallePedido2);

		pedido.setDetallesPedidos(detallesPedidos);

		pedidoDAO.create(pedido);

		assertTrue(pedido.getPedidoId() > 0 && pedido.getDetallesPedidos().size() == 2);

	}

	@Test
	public void testUpdateVideojuegoPedidoDireccionEnvio() {
		Integer pedidoId = 4;
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId);
		pedido.setDireccionEnvio("Dirección cambiada");

		pedidoDAO.update(pedido);

		VideojuegoPedido pedidoActualizado = pedidoDAO.get(pedidoId);

		assertEquals(pedido.getDireccionEnvio(), pedidoActualizado.getDireccionEnvio());
	}

	@Test
	public void testUpdateVideojuegoPedidoDetallesPedido() {
		Integer pedidoId = 5;
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId);

		Iterator<DetallesPedido> iterator = pedido.getDetallesPedidos().iterator();

		while (iterator.hasNext()) {
			DetallesPedido pedidoDetalle = iterator.next();
			if (pedidoDetalle.getVideojuego().getVideojuegoId() == 11) {
				pedidoDetalle.setCantidad(3);
				pedidoDetalle.setSubtotal(150);
			}
		}

		pedidoDAO.update(pedido);

		VideojuegoPedido pedidoActualizado = pedidoDAO.get(pedidoId);

		iterator = pedido.getDetallesPedidos().iterator();

		int cantidadEsperada = 3;
		float subtotalEsperado = 150;
		int cantidadActual = 0;
		float subtotalActual = 0;

		while (iterator.hasNext()) {
			DetallesPedido detallesPedido = iterator.next();
			if (detallesPedido.getVideojuego().getVideojuegoId() ==11) {
				cantidadActual = detallesPedido.getCantidad();
				subtotalActual = detallesPedido.getSubtotal();
			}
		}
		
		assertEquals(cantidadEsperada, cantidadActual);
		assertEquals(subtotalEsperado, subtotalActual, 0.0f);
	}

	@Test
	public void testGet() {
		Integer pedidoId = 4;
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId);

		assertEquals(1, pedido.getDetallesPedidos().size());
	}
	
	@Test
	public void testGetByIdAndCustomerNull() {
		Integer pedidoId= 10;
		Integer clienteId = 99;
		
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId, clienteId);
		
		assertNull(pedido);
	}
	
	
	@Test
	public void testGetByIdAndCustomerNotNull() {
		Integer pedidoId= 5;
		Integer clienteId = 5;
		
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId, clienteId);
		
		assertNotNull(pedido);
	}

	@Test
	public void testDeletePedido() {
		int pedidoId = 4;
		pedidoDAO.delete(pedidoId);
		
		VideojuegoPedido pedido = pedidoDAO.get(pedidoId);
		
		assertNull(pedido);
	}

	@Test
	public void testListAll() {

		List<VideojuegoPedido> listaPedidos = pedidoDAO.listAll();

		for (VideojuegoPedido pedido : listaPedidos) {
			System.out.println(pedido.getPedidoId() + " - " + pedido.getCliente().getNombrecompleto());

			for (DetallesPedido detalle : pedido.getDetallesPedidos()) {
				Videojuego videojuego = detalle.getVideojuego();

				System.out.println("\t" + videojuego.getTitulo());
			}

		}

		assertTrue(listaPedidos.size() > 0);
	}

	
	@Test
	public void testListByCustomerNoOrders() {
		Integer clienteId = 99;
		
		List<VideojuegoPedido> listaPedidos = pedidoDAO.listByCustomer(clienteId);
		 assertTrue(listaPedidos.isEmpty());
	}
	
	@Test
	public void testListByCustomerHaveOrders() {
		Integer clienteId = 5;
		
		List<VideojuegoPedido> listaPedidos = pedidoDAO.listByCustomer(clienteId);
		 assertTrue(listaPedidos.size()>0);
	}
	
	

	@Test
	public void testCount() {
		long totalPedidos = pedidoDAO.count();
		assertEquals(2, totalPedidos);
	}
	
	@Test
	public void testListMostRecentSales() { //Falla porque sólo hice 1 venta
		List<VideojuegoPedido> pedidoRecientes = pedidoDAO.listMostRecentSales();
		
		assertEquals(3, pedidoRecientes.size());
	}

}
