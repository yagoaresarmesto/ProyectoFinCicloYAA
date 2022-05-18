package com.videojuegoshop.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.videojuegoshop.dao.CategoriaDAO;
import com.videojuegoshop.enitity.Categoria;

@WebFilter("/*")
public class CommonFilter implements Filter {

	private final CategoriaDAO categoriaDAO;

	public CommonFilter() {
		categoriaDAO = new CategoriaDAO();
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (!path.startsWith("/admin/")) {
	
			List<Categoria> listaCategoria = categoriaDAO.listAll();
			request.setAttribute("listaCategoria", listaCategoria);
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
