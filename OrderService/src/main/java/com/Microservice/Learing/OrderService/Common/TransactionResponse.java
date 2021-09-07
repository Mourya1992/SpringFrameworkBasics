package com.Microservice.Learing.OrderService.Common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter


public class TransactionResponse {
	
	private int orderId;
	private double price;
	private String transactionId;
	private String status;
	public TransactionResponse(int orderId, double price, String transactionId, String status) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.transactionId = transactionId;
		this.status = status;
	}
	
	

}
