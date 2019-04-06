package com.store.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entities.OrderItem;
import com.store.repositories.OrderItemRepository;


@Service
public class OrderItemServiceImpl {

	@Autowired
	OrderItemRepository repository;

	public OrderItem save(OrderItem orderItem) {
		return this.repository.save(orderItem);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	public OrderItem update(OrderItem orderItem) {
		return this.repository.save(orderItem);
	}

	public Optional<OrderItem> searchById(Long id) {
		return this.repository.findById(id);
	}
}
