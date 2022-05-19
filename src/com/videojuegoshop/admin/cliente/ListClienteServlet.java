package com.videojuegoshop.admin.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.service.ClienteServices;


@WebServlet("/admin/list_customer")
public class ListClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListClienteServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ClienteServices clienteServices = new ClienteServices(request, response);
		clienteServices.listClientes();
	}

}
