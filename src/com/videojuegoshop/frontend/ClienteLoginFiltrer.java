package com.videojuegoshop.frontend;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "ClienteLoginFilter", urlPatterns = { "/*" })
public class ClienteLoginFiltrer implements Filter {

	public ClienteLoginFiltrer() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}

		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;

		System.out.println("Path: " + path);
		System.out.println("loggedIn: " + loggedIn);

		if (!loggedIn && path.startsWith("/view_profile")) {
			String loginPage = "frontend/login.jsp";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(httpRequest, response);
		
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
