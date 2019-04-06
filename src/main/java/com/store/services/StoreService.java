package com.store.services;
import java.util.List;
import java.util.Optional;

import com.store.entities.Store;

public interface StoreService {
	
	/**
	 * Cadastra uma nova loja.
	 * 
	 * @param store
	 * @return Store
	 */
	Store save(Store store);
	
	/**
	 * Exclui uma loja
	 * @param store
	 */
	void delete(Long id);
	
	/**
	 * Atualiza uma loja
	 * @param store
	 * @return Store
	 */
	Store update(Store store);
	
	/**
	 * Retorna uma loja pelo id.
	 * 
	 * @param name
	 * @return Optional<Store>
	 */
	Optional<Store> searchById(Long id);
	
	/**
	 * Retorna todas lojas cadastradas.
	 * 
	 * @return Optional<Store>
	 */
	List<Store> searchAll();

}
