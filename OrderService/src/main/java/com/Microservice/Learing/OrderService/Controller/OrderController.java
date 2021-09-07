package com.Microservice.Learing.OrderService.Controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Microservice.Learing.OrderService.Common.Payment;
import com.Microservice.Learing.OrderService.Common.TransactionRequest;
import com.Microservice.Learing.OrderService.Common.TransactionResponse;
import com.Microservice.Learing.OrderService.Entity.OrderDetails;
import com.Microservice.Learing.OrderService.Service.OrderService;

@RestController
@RequestMapping("/orderApi")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	WebClient.Builder webclient;
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("/orders")
	public List<OrderDetails> getOrderDetails() {
		logger.info("getting all the order details");
		return orderService.getOrders();
	}

	@PostMapping("/placeorder")
	public ResponseEntity<TransactionResponse> saveOrderDetails(@RequestBody TransactionRequest transactionRequest) {
		logger.info("placing the order details {}", transactionRequest);
		TransactionResponse transactionResponse = null;
		if (transactionRequest != null) {
			transactionResponse = orderService.saveOrder(transactionRequest);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(transactionResponse.getOrderId()).toUri();

		return ResponseEntity.created(location).body(transactionResponse);

	}

	@GetMapping("/getOrderDetails/{orderid}")
	public ResponseEntity<TransactionResponse> getPaymentDetailsByOrderId(@PathVariable int orderid) {
		logger.info("Fetching your order details,for you order with orderId {}", orderid);

		TransactionResponse trResponse = webclient.build().get()
				.uri("http://PAYMENT-SERVICE/PayTM/paymentByOrderId/" + orderid).retrieve()
				.bodyToMono(TransactionResponse.class).block();

		ResponseEntity<TransactionResponse> responseEntity = new ResponseEntity<TransactionResponse>(trResponse,
				HttpStatus.OK);
		return responseEntity;
	}

}
