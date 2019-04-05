package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
