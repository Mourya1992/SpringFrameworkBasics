package com.Microservice.Learing.PaymentService.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Microservice.Learing.PaymentService.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public Optional<Payment> findByOrderId(int orderId);

}
