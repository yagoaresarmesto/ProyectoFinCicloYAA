package com.videojuegoshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.hql.internal.classic.ClauseParser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.videojuegoshop.enitity.Cliente;

public class ClienteDAOTest {

	private static ClienteDAO clienteDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		clienteDao = new ClienteDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		clienteDao.close();
	}

	@Test
	public void testCreateCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail("jesusares@gmail.com");
		cliente.setNombrecompleto("Jesus Ares Armesto");
		cliente.setCiudad("Lugo");
		cliente.setPais("España");
		cliente.setDireccion("Obispo Aguirre");
		cliente.setContraseña("saltamontes1234");
		cliente.setTelefono("639010343");
		cliente.setCodigopostal("27002");

		Cliente clienteGuardado = clienteDao.create(cliente);
		assertTrue(clienteGuardado.getClienteId() > 0);
	}

	@Test
	public void testGet() {
		Integer clienteId = 3;
		Cliente cliente = clienteDao.get(clienteId);

		assertNotNull(cliente);
	}

	@Test
	public void testUpdateCliente() {
		Cliente cliente = clienteDao.get(3);
		String nombreCompleto = "Jesus Ares Armesto";
		cliente.setNombrecompleto(nombreCompleto);
		Cliente clienteActualizado = clienteDao.update(cliente);

		assertTrue(clienteActualizado.getNombrecompleto().equals(nombreCompleto));
	}

	@Test
	public void testDeleteCliente() {
		Integer clienteId = 3;
		clienteDao.delete(clienteId);
		Cliente cliente = clienteDao.get(3);

		assertNull(cliente);
	}

	@Test
	public void testListAll() {
		List<Cliente> listaClientes = clienteDao.listAll();

		for (Cliente cliente : listaClientes) {
			System.out.println(cliente.getNombrecompleto());
		}
		assertFalse(listaClientes.isEmpty());
	}

	@Test
	public void testCount() {
		long totalCLientes =  clienteDao.count();
		assertEquals(2, totalCLientes);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "yagoares1@gmail.com";
		Cliente cliente = clienteDao.findByEmail(email);
		
		assertNotNull(cliente);
	}
	
	@Test
	public void testCheckLoginSucces() {
		String email = "yagoares@gmail.com";
		String password ="saltamontes1234";
		
		Cliente cliente = clienteDao.checkLogin(email, password);
		
		assertNotNull(cliente);
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "jajaajja@gmail.com";
		String password ="saltamontes1234";
		
		Cliente cliente = clienteDao.checkLogin(email, password);
		
		assertNull(cliente);
	}
	
	
}
