package com.store.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entities.Payment;
import com.store.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentService repository;
	

	public Payment save(Payment payment) {
		return this.repository.save(payment);
	}


	public void delete(Long id) {
		this.repository.delete(id);
	}


	public Payment update(Payment payment) {
		return this.repository.save(payment);
	}

	public Optional<Payment> searchById(Long id) {
		return this.repository.searchById(id);
	}

	public List<Payment> searchAll() {
		return this.repository.searchAll();
	}

}
