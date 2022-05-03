package com.videojuegoshop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.dao.UsuarioDAO;
import com.videojuegoshop.enitity.Usuarios;

public class UsuarioServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UsuarioDAO usuarioDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UsuarioServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

		entityManagerFactory = Persistence.createEntityManagerFactory("PFCYAA");
		entityManager = entityManagerFactory.createEntityManager();
		usuarioDAO = new UsuarioDAO(entityManager);
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Usuarios> listaUsuarios = usuarioDAO.listAll();

		request.setAttribute("listaUsuarios", listaUsuarios);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

	public void createUser() throws ServletException, IOException {

		String email = request.getParameter("email");
		String apellidos = request.getParameter("apellidos");
		String contraseña = request.getParameter("contraseña");

		Usuarios existeUsuario = usuarioDAO.findByEmail(email);

		if (existeUsuario != null) {
			String message = "No se puede crear el usuario. Correo " + email + " ya registrado por otro usuario";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {
			Usuarios nuevoUsuario = new Usuarios(email, apellidos, contraseña);
			usuarioDAO.create(nuevoUsuario);
			listUser("Usuario creado correctamente");
		}
	}

	public void editUser() throws ServletException, IOException {

		int usuarioId = Integer.parseInt(request.getParameter("id"));
		Usuarios usuario = usuarioDAO.get(usuarioId);

		String editPage = "user_form.jsp";
		request.setAttribute("usuario", usuario);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);

	}

	public void updateUser() throws ServletException, IOException {
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		String email = request.getParameter("email");
		String apellidos = request.getParameter("apellidos");
		String contraseña = request.getParameter("contraseña");

		Usuarios usuarioById = usuarioDAO.get(usuarioId);

		Usuarios usuarioByEmail = usuarioDAO.findByEmail(email);

		if (usuarioByEmail != null && usuarioByEmail.getUsuarioId() != usuarioById.getUsuarioId()) {
			String message = "No se pudo actualizar el usuario, el email ya ha sido usado";
			request.setAttribute("message", message);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);

		} else {
			Usuarios usuario = new Usuarios(usuarioId, email, apellidos, contraseña);
			usuarioDAO.update(usuario);

			String message = "Usuario ha sido actualizado con éxito";
			listUser(message);
		}

	}

}
