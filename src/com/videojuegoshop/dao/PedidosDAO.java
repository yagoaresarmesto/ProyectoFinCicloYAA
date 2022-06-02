package com.videojuegoshop.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.videojuegoshop.enitity.Videojuego;
import com.videojuegoshop.enitity.VideojuegoPedido;

public class PedidosDAO extends JpaDAO<VideojuegoPedido> implements GenericDAO<VideojuegoPedido> {

	@Override
	public VideojuegoPedido create(VideojuegoPedido pedido) {

		pedido.setFechaPedido(new Date());
		pedido.setEstadoPedido("En Proceso");

		return super.create(pedido);
	}

	@Override
	public VideojuegoPedido update(VideojuegoPedido pedido) {
		return super.update(pedido);

	}

	@Override
	public VideojuegoPedido get(Object pedidoId) {
		return super.find(VideojuegoPedido.class, pedidoId);
	}
	
	public VideojuegoPedido get(Integer pedidoId, Integer clienteId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("pedidoId", pedidoId);
		parameters.put("clienteId", clienteId);
		
		List<VideojuegoPedido> result = super.findWithNamedQuery("VideojuegoPedido.findByIdAndCustomer", parameters );
		
		if (!result.isEmpty()) {
			
			return result.get(0);
		}
		return null;
	}

	@Override
	public void delete(Object pedidoId) {
		super.delete(VideojuegoPedido.class, pedidoId);
	}

	@Override
	public List<VideojuegoPedido> listAll() {

		return super.findWithNamedQuery("VideojuegoPedido.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("VideojuegoPedido.countAll");
	}

	
	public List<VideojuegoPedido> listByCustomer(Integer clienteId) {
		return super.findWithNamedQuery("VideojuegoPedido.findByCustomer", 
				"clienteId", clienteId);
	}
	
	
	public List<VideojuegoPedido> listMostRecentSales() {
		return super.findWithNamedQuery("VideojuegoPedido.findAll", 0, 3);
	}

}
