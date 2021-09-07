package com.Microservice.Learing.PaymentService.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservice.Learing.PaymentService.Dao.PaymentRepository;
import com.Microservice.Learing.PaymentService.Entity.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	public Payment addPayment(Payment payment) {

		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setStatus(doPayment());
		return paymentRepository.save(payment);
	}

	public Optional<Payment> getPayment(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}

	public List<Payment> getPayment() {
		return paymentRepository.findAll();
	}

	public String doPayment() {

		return new Random().nextBoolean() ? "Success" : "Failure";
	}

	public Optional<Payment> findByOrderId(int orderId) {

		return paymentRepository.findByOrderId(orderId);
	}
}
