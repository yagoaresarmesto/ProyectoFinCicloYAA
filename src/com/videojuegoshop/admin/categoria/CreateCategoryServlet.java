package com.videojuegoshop.admin.categoria;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.CategoriaServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public CreateCategoryServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaServices categoryServicies = new CategoriaServices(entityManager, request, response);
		categoryServicies.createCategory();

	}

}
