package com.store.services;

import java.util.List;
import java.util.Optional;

import com.store.entities.Order;

public interface OrderService {
	
	/**
	 * Cadastra um novo pedido.
	 * 
	 * @param order
	 * @return Order
	 */
	Order save(Order order);
	
	/**
	 * Exclui um pedido
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Atualiza um pedido
	 * @param order
	 */
	Order update(Order order);
	
	/**
	 * Retorna um pedido pelo id.
	 * 
	 * @param id
	 * @return Optional<Order>
	 */
	Optional<Order> searchById(Long id);
	
	/**
	 * Retorna todos pedidos cadastrados.
	 * 
	 * @return Optional<Order>
	 */
	List<Order> searchAll();

}
