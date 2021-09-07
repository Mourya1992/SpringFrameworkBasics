package com.Microservice.Learing.PaymentService.Controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Microservice.Learing.PaymentService.Entity.Payment;
import com.Microservice.Learing.PaymentService.Service.PaymentService;

@RestController
@RequestMapping("/PayTM")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@GetMapping("/payment/{paymentId}")
	public Optional<Payment> getPayment(@PathVariable int paymentId) {

		return paymentService.getPayment(paymentId);
	}

	@GetMapping("/paymentByOrderId/{orderId}")
	public Optional<Payment> getPaymentDtlsWithOrderId(@PathVariable int orderId) {

		return paymentService.findByOrderId(orderId);
	}

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		logger.info("adding the payments details:");

		Payment paymentdtls = paymentService.addPayment(payment);
		logger.info("payment process:{}", paymentdtls.getStatus());
		return paymentdtls;
	}

	@GetMapping("/payments")
	public List<Payment> allPayments() {

		logger.info("getting all the payments from the database");

		return paymentService.getPayment();
	}

}
