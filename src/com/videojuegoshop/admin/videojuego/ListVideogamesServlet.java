package com.videojuegoshop.admin.videojuego;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.VideojuegoServices;


@WebServlet("/admin/list_videojuegos")
public class ListVideogamesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	VideojuegoServices videojuegoServices =  new VideojuegoServices(entityManager, request, response);
	videojuegoServices.listarVideojuegos();
	
	
	
	}

}
