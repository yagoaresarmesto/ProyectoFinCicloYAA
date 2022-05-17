package com.videojuegoshop.admin.categoria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.videojuegoshop.service.CategoriaServices;

@WebServlet("/admin/list_category")
public class ListCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ListCategoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("Lista categoria:");
		CategoriaServices categoriaServices = new CategoriaServices(request, response);
		categoriaServices .listCategory();
	}

}
