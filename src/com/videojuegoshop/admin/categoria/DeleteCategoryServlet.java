package com.videojuegoshop.admin.categoria;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.CategoriaServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCategoryServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaServices categoriaServices = new CategoriaServices(entityManager, request, response);
		categoriaServices.deleteCategory();
	}

}
