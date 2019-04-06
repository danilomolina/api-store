package com.store.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entities.Order;
import com.store.repositories.OrderRepository;


@Service
public class OrderServiceImpl {

	@Autowired
	OrderRepository repository;

	public Order save(Order order) {
		return this.repository.save(order);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	public Order update(Order order) {
		return this.repository.save(order);
	}

	public Optional<Order> searchById(Long id) {
		return this.repository.findById(id);
	}

	public List<Order> searchAll() {
		return this.repository.findAll();
	}

}
