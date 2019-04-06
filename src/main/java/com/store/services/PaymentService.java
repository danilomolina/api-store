package com.store.services;

import java.util.List;
import java.util.Optional;

import com.store.entities.Payment;



public interface PaymentService {
	
	/**
	 * Cadastra um novo pagamento.
	 * 
	 * @param payment
	 * @return Payment
	 */
	Payment save(Payment payment);
	
	/**
	 * Exclui um pagamento
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Atualiza um pagamento
	 * @param payment
	 */
	Payment update(Payment payment);
	
	/**
	 * Retorna um pagamento pelo id.
	 * 
	 * @param id
	 * @return Optional<Payment>
	 */
	Optional<Payment> searchById(Long id);
	
	/**
	 * Retorna todos pagamentos cadastrados.
	 * 
	 * @return Optional<Order>
	 */
	List<Payment> searchAll();


}
