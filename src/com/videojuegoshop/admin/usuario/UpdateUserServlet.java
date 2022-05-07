package com.videojuegoshop.admin.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videojuegoshop.controller.BaseServlet;
import com.videojuegoshop.service.UsuarioServices;


@WebServlet("/admin/update_user")
public class UpdateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUserServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UsuarioServices usuarioServices= new UsuarioServices(entityManager, request, response);
		usuarioServices.updateUser();
	}

}
