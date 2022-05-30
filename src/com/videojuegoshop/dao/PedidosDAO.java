package com.videojuegoshop.dao;

import java.util.Date;
import java.util.List;

import com.videojuegoshop.enitity.VideojuegoPedido;

public class PedidosDAO extends JpaDAO<VideojuegoPedido> implements GenericDAO<VideojuegoPedido> {

	@Override
	public VideojuegoPedido create(VideojuegoPedido pedido) {

		pedido.setFechaPedido(new Date());
		pedido.setMetodoPago("Tarjeta de cr�dito");
		pedido.setEstadoPedido("Proccessing");

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

}