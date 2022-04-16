package com.videojuegoshop.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.enitity.Usuarios;
import com.videojuegoshop.service.UsuarioServices;

@WebServlet("/admin/list_usuarios")
public class ListUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListUsuariosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioServices usuarioServices = new UsuarioServices();
		List<Usuarios> listaUsuarios = usuarioServices.listUser();
		request.setAttribute("listaUsuarios", listaUsuarios);
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

}
