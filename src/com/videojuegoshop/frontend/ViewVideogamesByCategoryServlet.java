package com.videojuegoshop.frontend;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.VideojuegoServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_category")
public class ViewVideogamesByCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ViewVideogamesByCategoryServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideojuegoServices videojuegoServices = new VideojuegoServices(entityManager, request, response);
		videojuegoServices.listVideogameByCategory();
	}

}
