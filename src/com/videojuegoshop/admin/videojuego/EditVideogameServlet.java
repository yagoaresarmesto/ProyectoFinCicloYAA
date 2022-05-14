package com.videojuegoshop.admin.videojuego;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.VideojuegoServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/edit_videogame")
public class EditVideogameServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public EditVideogameServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VideojuegoServices videojuegoServices = new VideojuegoServices(entityManager, request, response);
		videojuegoServices.editVideogame();
	}

}
