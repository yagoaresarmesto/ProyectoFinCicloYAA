package com.videojuegoshop.admin.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.admin.BaseServlet;
import com.videojuegoshop.service.UsuarioServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	UsuarioServices usuarioServicies = new UsuarioServices(entityManager, request, response);
	usuarioServicies.createUser();
	
	}

}
