package com.store.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.controllers.util.ResponseList;
import com.store.controllers.util.ResponseOptional;
import com.store.entities.Store;
import com.store.services.StoreService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class StoreController {
	
	private static final Logger log = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService service;
	
	/**
	 * Cadastra uma nova loja
	 * @param store
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping(value="/store")
	public ResponseEntity<ResponseOptional<Store>> save(@Valid @RequestBody Store store,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Cadastrando uma nova loja: {}", store.toString());
		
		ResponseOptional<Store> response = new ResponseOptional<Store>();
	
		this.service.save(store);
		
		response.setData(Optional.ofNullable(store));

		return ResponseEntity.ok(response);
	}
	
	/**
	 * Exclui uma loja
	 * @param id
	 * @throws NoSuchAlgorithmException
	 */
	@DeleteMapping(value="/store/{id}")
	public ResponseEntity<ResponseOptional<Store>> delete(@PathVariable("id") Long id) throws NoSuchAlgorithmException {
		
		log.info("Excluindo a loja com id : {}", id);
		Optional<Store> store = this.service.searchById(id);
		ResponseOptional<Store> response = new ResponseOptional<Store>();
		
		if (!store.isPresent()) {
			log.info("Loja não encontrada com o ID: {}", id);
			response.getErrors().add("Loja não encontrada com o ID " + id);
			return ResponseEntity.badRequest().body(response);
		}else {	
			this.service.delete(id);
			response.setMessages("Excluido com sucesso!");
		}

		return ResponseEntity.ok(response);
	}
	
	/**
	 * Atualiza uma loja
	 * @param store
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PutMapping(value="/store")
	public ResponseEntity<ResponseOptional<Store>> update(@Valid @RequestBody Store store,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Atualizando a loja: {}", store.toString());
		
		ResponseOptional<Store> response = new ResponseOptional<Store>();
	
		this.service.update(store);

		response.setData(Optional.ofNullable(store));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca loja pelo id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/store/{id}")
	public ResponseEntity<ResponseOptional<Store>> searchById(@PathVariable("id") Long id) {
		
		log.info("Buscando loja pelo ID: {}", id);
		
		ResponseOptional<Store> response = new ResponseOptional<Store>();
		Optional<Store> store = this.service.searchById(id);		

		if (!store.isPresent()) {
			log.info("Loja não encontrada com o ID: {}", id);
			response.getErrors().add("Loja não encontrada com o ID " + id);
			return ResponseEntity.badRequest().body(response);
		}else
			response.setData(store);
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca todas as loja
	 * @return
	 */
	@GetMapping(value = "/store")
	public ResponseEntity<ResponseList<Store>> searchAll() {
		
		log.info("Buscando lojas");
		
		ResponseList<Store> response = new ResponseList<Store>();
		List<Store> store = this.service.searchAll();		

		if (store.isEmpty()) {
			log.info("Nenhuma loja cadastrada!");
			response.getErrors().add("Nenhuma loja cadastrada!");
			return ResponseEntity.badRequest().body(response);
		}else 
			response.setData(store);
		
		return ResponseEntity.ok(response);
	}

}
