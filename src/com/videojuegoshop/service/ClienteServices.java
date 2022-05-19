package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.ClienteDAO;
import com.videojuegoshop.enitity.Cliente;

public class ClienteServices {

	private ClienteDAO clienteDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ClienteServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.clienteDAO = new ClienteDAO();
	}

	public void listClientes(String message) throws ServletException, IOException {
		List<Cliente> listaCliente = clienteDAO.listAll();

		if (message != null) {
			request.setAttribute("message", message);
		}

		request.setAttribute("listaCliente", listaCliente);

		String listPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public void listClientes() throws ServletException, IOException {
		listClientes(null);
	}

	public void createCliente() throws ServletException, IOException {

		String email = request.getParameter("email");
		Cliente existeCliente = clienteDAO.findByEmail(email);

		if (existeCliente != null) {
			String message = "Could not create new customer: the email " + email
					+ " is already registered by another customer.";
			listClientes(message);

		} else {

			String nombreCompleto = request.getParameter("nombreCompleto");
			String contraseña = request.getParameter("contraseña");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			String ciudad = request.getParameter("ciudad");
			String codigoPostal = request.getParameter("codigoPostal");
			String pais = request.getParameter("pais");

			Cliente newCliente = new Cliente();
			newCliente.setEmail(email);
			newCliente.setNombrecompleto(nombreCompleto);
			newCliente.setContraseña(contraseña);
			newCliente.setTelefono(telefono);
			newCliente.setDireccion(direccion);
			newCliente.setCiudad(ciudad);
			newCliente.setCodigopostal(codigoPostal);
			newCliente.setPais(pais);

			clienteDAO.create(newCliente);

			String message = "Nuevo cliente creado con éxito";
			listClientes(message);

		}

	}
}
