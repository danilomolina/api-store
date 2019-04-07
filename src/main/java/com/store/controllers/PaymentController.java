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
import com.store.entities.Payment;
import com.store.services.PaymentService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PaymentController {
private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private PaymentService service;
	
	/**
	 * Cadastra um novo pagamento
	 * @param payment
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping(value="/payment")
	public ResponseEntity<ResponseOptional<Payment>> save(@Valid @RequestBody Payment payment,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Cadastrando um novo pagamento: {}", payment.toString());
		
		ResponseOptional<Payment> response = new ResponseOptional<Payment>();
	
		this.service.save(payment);
		
		response.setData(Optional.ofNullable(payment));

		return ResponseEntity.ok(response);
	}
	
	/**
	 * Exclui um pagamento
	 * @param id
	 * @throws NoSuchAlgorithmException
	 */
	@DeleteMapping(value="/payment/{id}")
	public ResponseEntity<ResponseOptional<Payment>> delete(@PathVariable("id") Long id) throws NoSuchAlgorithmException {
		
		log.info("Excluindo o pagamento com id : {}", id);
		Optional<Payment> payment = this.service.searchById(id);
		ResponseOptional<Payment> response = new ResponseOptional<Payment>();
		
		if (!payment.isPresent()) {
			log.info("Pagamento não encontrado com o ID: {}", id);
			response.getErrors().add("Pagamento não encontrado com o ID " + id);
			return ResponseEntity.badRequest().body(response);
		}else {	
			this.service.delete(id);
			response.setMessages("Excluido com sucesso!");
		}

		return ResponseEntity.ok(response);
	}
	
	/**
	 * Atualiza um pagamento
	 * @param payment
	 * @param result
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PutMapping(value="/payment")
	public ResponseEntity<ResponseOptional<Payment>> update(@Valid @RequestBody Payment payment,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Atualizando o pagamento: {}", payment.toString());
		Optional<Payment> _payment = this.service.searchById(payment.getId());
		
		ResponseOptional<Payment> response = new ResponseOptional<Payment>();
		
		if (!_payment.isPresent()) {
			log.info("Pagamento não encontrado com o ID: {}", payment.getId());
			response.getErrors().add("Pagamento não encontrado com o ID " + payment.getId());
			return ResponseEntity.badRequest().body(response);
		}else {
          this.service.update(payment);
          response.setData(Optional.ofNullable(payment));
		}
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca um pagamento pelo id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/payment/{id}")
	public ResponseEntity<ResponseOptional<Payment>> searchById(@PathVariable("id") Long id) {
		
		log.info("Buscando pagamento pelo ID: {}", id);
		
		ResponseOptional<Payment> response = new ResponseOptional<Payment>();
		Optional<Payment> payment = this.service.searchById(id);		

		if (!payment.isPresent()) {
			log.info("Pagamneto não encontrado com o ID: {}", id);
			response.getErrors().add("Pagamento não encontrado com o ID " + id);
			return ResponseEntity.badRequest().body(response);
		}else
			response.setData(payment);
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca todos os pagamentos
	 * @return
	 */
	@GetMapping(value = "/payment")
	public ResponseEntity<ResponseList<Payment>> searchAll() {
		
		log.info("Buscando pagamentos");
		
		ResponseList<Payment> response = new ResponseList<Payment>();
		List<Payment> payment = this.service.searchAll();		

		if (payment.isEmpty()) {
			log.info("Nenhum pagamento cadastrado!");
			response.getErrors().add("Nenhum pagamento cadastrado!");
			return ResponseEntity.badRequest().body(response);
		}else 
			response.setData(payment);
		
		return ResponseEntity.ok(response);
	}

}
