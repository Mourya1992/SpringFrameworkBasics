package com.Microservice.Learing.OrderService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Microservice.Learing.OrderService.Common.Payment;
import com.Microservice.Learing.OrderService.Common.TransactionRequest;
import com.Microservice.Learing.OrderService.Common.TransactionResponse;
import com.Microservice.Learing.OrderService.Dao.OrderRepository;
import com.Microservice.Learing.OrderService.Entity.OrderDetails;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestTemplate resttemplate;

	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		Payment paymentdtls = transactionRequest.getPayment();
		System.out.println(transactionRequest);
		OrderDetails orderDtls = orderRepository.save(transactionRequest.getOrder());
		String status = "";

		paymentdtls.setOrderId(orderDtls.getId());
		paymentdtls.setPrice(orderDtls.getPrice());
		// Rest template call,Can be modified and made using WebClient
		Payment paymentResponse = resttemplate.postForObject("http://PAYMENT-SERVICE/PayTM/payment", paymentdtls,
				Payment.class);
		System.out.println(paymentResponse);
		status = paymentResponse.getStatus().equals("Success")
				? "Payment Successfull,Your order will soon arrive at ur Door Step"
				: "Payment Failled,Please try again after sometime";

		return new TransactionResponse(orderDtls.getId(), orderDtls.getPrice(), paymentResponse.getTransactionId(),
				status);
	}

	public List<OrderDetails> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<OrderDetails> getOrderById(int id) {
		return orderRepository.findById(id);
	}
}
