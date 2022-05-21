package com.videojuegoshop.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.videojuegoshop.enitity.Cliente;

public class ClienteDAO extends JpaDAO<Cliente> implements GenericDAO<Cliente> {

	@Override
	public Cliente create(Cliente cliente) {
		cliente.setFechaRegistro(new Date());
		return super.create(cliente);
	}

	@Override
	public Cliente get(Object id) {
		return super.find(Cliente.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Cliente.class, id);
	}

	// Sin funcionar
	@Override
	public List<Cliente> listAll() {
		return super.findWithNamedQuery("Cliente.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Cliente.countAll");

	}

	public Cliente findByEmail(String email) {
		List<Cliente> resultado = super.findWithNamedQuery("Cliente.findByEmail", "email", email);
		if (!resultado.isEmpty()) {
			return resultado.get(0);
		}
		
		return null;
	}

	public Cliente checkLogin(String email, String password) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("pass", password);
		
		List<Cliente> resultado = super.findWithNamedQuery("Cliente.checkLogin", parameters);
		
		
		if(!resultado.isEmpty()) {
			return resultado.get(0);
		}
		
		return null;
		
	}
}
