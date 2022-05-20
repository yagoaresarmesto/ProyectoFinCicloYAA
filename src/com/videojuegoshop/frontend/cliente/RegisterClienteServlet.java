package com.videojuegoshop.frontend.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.service.ClienteServices;

@WebServlet("/register_customer")
public class RegisterClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterClienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteServices clienteServices = new ClienteServices(request, response);
		clienteServices.registerCliente();
	}

}
