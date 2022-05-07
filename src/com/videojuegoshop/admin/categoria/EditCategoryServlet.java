package com.videojuegoshop.admin.categoria;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.CategoriaServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public EditCategoryServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoriaServices categoryServices = new CategoriaServices(entityManager, request, response);
		categoryServices.editCategory();
	}

}
