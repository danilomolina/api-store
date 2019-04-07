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
import com.store.entities.Order;
import com.store.services.OrderService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;
	
	/**
	 * Cadastra uma nova venda
	 * @param order
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping(value="/order")
	public ResponseEntity<ResponseOptional<Order>> save(@Valid @RequestBody Order order,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Cadastrando uma nova venda: {}", order.toString());
		
		ResponseOptional<Order> response = new ResponseOptional<Order>();
	
		this.service.save(order);
		
		response.setData(Optional.ofNullable(order));

		return ResponseEntity.ok(response);
	}
	
	/**
	 * Exclui uma venda
	 * @param id
	 * @throws NoSuchAlgorithmException
	 */
	@DeleteMapping(value="/order/{id}")
	public ResponseEntity<ResponseOptional<Order>> delete(@PathVariable("id") Long id) throws NoSuchAlgorithmException {
		
		log.info("Excluindo a venda com id : {}", id);
		Optional<Order> order = this.service.searchById(id);
		ResponseOptional<Order> response = new ResponseOptional<Order>();
		
		if (!order.isPresent()) {
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
	 * Atualiza uma venda
	 * @param store
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PutMapping(value="/order")
	public ResponseEntity<ResponseOptional<Order>> update(@Valid @RequestBody Order order,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Atualizando a venda: {}", order.toString());
		Optional<Order> _order = this.service.searchById(order.getId());
		
		ResponseOptional<Order> response = new ResponseOptional<Order>();
		
		if (!_order.isPresent()) {
			log.info("Venda não encontrada com o ID: {}", order.getId());
			response.getErrors().add("Venda não encontrada com o ID " + order.getId());
			return ResponseEntity.badRequest().body(response);
		}else {
          this.service.update(order);
          response.setData(Optional.ofNullable(order));
		}
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca uma venda pelo id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/order/{id}")
	public ResponseEntity<ResponseOptional<Order>> searchById(@PathVariable("id") Long id) {
		
		log.info("Buscando venda pelo ID: {}", id);
		
		ResponseOptional<Order> response = new ResponseOptional<Order>();
		Optional<Order> order = this.service.searchById(id);		

		if (!order.isPresent()) {
			log.info("Venda não encontrada com o ID: {}", id);
			response.getErrors().add("Venda não encontrada com o ID " + id);
			return ResponseEntity.badRequest().body(response);
		}else
			response.setData(order);
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca todas as loja
	 * @return
	 */
	@GetMapping(value = "/order")
	public ResponseEntity<ResponseList<Order>> searchAll() {
		
		log.info("Buscando vendas");
		
		ResponseList<Order> response = new ResponseList<Order>();
		List<Order> store = this.service.searchAll();		

		if (store.isEmpty()) {
			log.info("Nenhuma venda cadastrada!");
			response.getErrors().add("Nenhuma venda cadastrada!");
			return ResponseEntity.badRequest().body(response);
		}else 
			response.setData(store);
		
		return ResponseEntity.ok(response);
	}

}
