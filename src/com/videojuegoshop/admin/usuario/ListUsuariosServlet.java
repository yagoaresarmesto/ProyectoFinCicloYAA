package com.videojuegoshop.admin.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.videojuegoshop.service.UsuarioServices;

@WebServlet("/admin/list_usuarios")
public class ListUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListUsuariosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioServices usuarioServices = new UsuarioServices(request, response);
		usuarioServices.listUser();

	}

}
