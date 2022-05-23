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

	private void updateClienteFiledsFromForm(Cliente cliente) {
		String email = request.getParameter("email");
		String nombreCompleto = request.getParameter("nombreCompleto");
		String contraseña = request.getParameter("contraseña");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String ciudad = request.getParameter("ciudad");
		String codigoPostal = request.getParameter("codigoPostal");
		String pais = request.getParameter("pais");

		if(email != null && !email.equals("")) {
			cliente.setEmail(email);
		}
	
		cliente.setNombrecompleto(nombreCompleto);
		if(contraseña != null && !contraseña.equals("")) {
		cliente.setContraseña(contraseña);
		}
		
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		cliente.setCiudad(ciudad);
		cliente.setCodigopostal(codigoPostal);
		cliente.setPais(pais);
	}

	public void createCliente() throws ServletException, IOException {

		String email = request.getParameter("email");
		Cliente existeCliente = clienteDAO.findByEmail(email);

		if (existeCliente != null) {
			String message = "No se puedo crear un cliente el email: " + email
					+ " ya ha sido registrado por otro usuario.";
			listClientes(message);

		} else {

			Cliente newCliente = new Cliente();
			updateClienteFiledsFromForm(newCliente);
			clienteDAO.create(newCliente);

			String message = "Nuevo cliente creado con éxito";
			listClientes(message);

		}

	}

	public void registerCliente() throws ServletException, IOException {

		String email = request.getParameter("email");
		Cliente existeCliente = clienteDAO.findByEmail(email);

		String message = "";
		if (existeCliente != null) {
			message = "No se puedo registrar el cliente con email: " + email
					+ " porque ha sido registrado por otro usuario.";
		} else {

			Cliente newCliente = new Cliente();
			updateClienteFiledsFromForm(newCliente);
			clienteDAO.create(newCliente);

			message = "Te has registrado con éxito!<br/>" + "<a href='login'>Click aquí </a> para loguearse";

		}

		String messagePage = "frontend/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		requestDispatcher.forward(request, response);

	}

	public void editCliente() throws ServletException, IOException {

		Integer clienteId = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDAO.get(clienteId);

		request.setAttribute("cliente", cliente);

		String editPage = "customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);

	}

	public void updateCliente() throws ServletException, IOException {

		Integer clienteId = Integer.parseInt(request.getParameter("clienteId"));
		String email = request.getParameter("email");

		Cliente clienteByEmail = clienteDAO.findByEmail(email);

		String message = null;
		if (clienteByEmail != null && clienteByEmail.getClienteId() != clienteId) {
			message = "No se puedo actulazar el cliente con ID " + clienteId
					+ "porque hay un cliente con el mismo email.";

		} else {

			Cliente clienteById = clienteDAO.get(clienteId);
			updateClienteFiledsFromForm(clienteById);
			clienteDAO.update(clienteById);

			message = "El cliente ha sido actualizado con éxito";
		}

		listClientes(message);

	}

	public void deleteCliente() throws ServletException, IOException {

		Integer clienteId = Integer.parseInt(request.getParameter("id"));
		clienteDAO.delete(clienteId);

		String message = "Cliente eliminado con éxito.";
		listClientes(message);

	}

	public void showLogin() throws ServletException, IOException {

		String loginPage = "frontend/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("contraseña");

		Cliente cliente = clienteDAO.checkLogin(email, password);

		if (cliente == null) {
			String message = "Login fallido. Porfavor comprueba tu correo o contraseña";
			request.setAttribute("message", message);
			showLogin();

		} else {
			request.getSession().setAttribute("loggedCustomer", cliente);
			showClienteProfile();
		}
	}

	public void showClienteProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showClienteProfileEditForm() throws ServletException, IOException {
		String editPage = "frontend/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateClienteProfile() throws ServletException, IOException {

		Cliente cliente = (Cliente) request.getSession().getAttribute("loggedCustomer");
		updateClienteFiledsFromForm(cliente);
		clienteDAO.update(cliente);
		
		showClienteProfile();
		
	}
}
