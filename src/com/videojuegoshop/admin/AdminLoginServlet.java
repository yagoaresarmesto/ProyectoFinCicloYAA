package com.videojuegoshop.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videojuegoshop.service.UsuarioServices;

@WebServlet("/admin/Login")
public class AdminLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioServices usuarioServicies = new UsuarioServices(request, response);
		usuarioServicies.login();

	}

}
