package com.videojuegoshop.admin.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.service.ClienteServices;

@WebServlet("/admin/update_customer")
public class UpdateClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateClienteServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteServices clienteServices = new ClienteServices(request, response);
		clienteServices.updateCliente();
		
		
	}

}
