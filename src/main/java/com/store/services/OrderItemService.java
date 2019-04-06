package com.store.services;

import java.util.Optional;

import com.store.entities.OrderItem;

public interface OrderItemService {
	
	/**
	 * Cadastra um novo item de pedido.
	 * 
	 * @param orderItem
	 * @return OrderItem
	 */
	OrderItem save(OrderItem orderItem);
	
	/**
	 * Exclui um item de pedido
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Atualiza um item de pedido
	 * @param orderItem
	 */
	OrderItem update(OrderItem orderItem);
	
	/**
	 * Retorna um item de pedido pelo id.
	 * 
	 * @param id
	 * @return Optional<OrderItem>
	 */
	Optional<OrderItem> searchById(Long id);

}
