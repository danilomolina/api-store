package com.store.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.entities.Store;
import com.store.repositories.StoreRepository;
import com.store.services.StoreService;

public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreRepository repository;

	@Override
	public Store save(Store store) {
		return repository.save(store);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Store update(Store store) {
		return repository.save(store);
	}

	@Override
	public Optional<Store> searchById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Store> searchAll() {
		return repository.findAll();
	}

}
