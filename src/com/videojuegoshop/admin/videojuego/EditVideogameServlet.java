package com.videojuegoshop.admin.videojuego;


import com.videojuegoshop.service.VideojuegoServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/edit_videogame")
public class EditVideogameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditVideogameServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VideojuegoServices videojuegoServices = new VideojuegoServices( request, response);
		videojuegoServices.editVideogame();
	}

}
