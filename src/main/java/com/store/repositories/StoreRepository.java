package com.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Store;


public interface StoreRepository extends JpaRepository<Store, Long>{

}
