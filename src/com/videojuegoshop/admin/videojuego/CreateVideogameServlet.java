package com.videojuegoshop.admin.videojuego;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.VideojuegoServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/create_videogame")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,	// 10 KB
		maxFileSize = 1024 * 300,		// 300 KB
		maxRequestSize = 1024 * 1024	// 1 MB 
		)
public class CreateVideogameServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public CreateVideogameServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VideojuegoServices videojuegoServices = new VideojuegoServices(entityManager, request, response);
		videojuegoServices.createVideojuego();
	
	}

}
