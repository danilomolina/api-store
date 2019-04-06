package com.store.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entities.Store;
import com.store.repositories.StoreRepository;
import com.store.services.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreRepository repository;

	@Override
	public Store save(Store store) {
		return this.repository.save(store);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public Store update(Store store) {
		return this.repository.save(store);
	}

	@Override
	public Optional<Store> searchById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Store> searchAll() {
		return this.repository.findAll();
	}

}
