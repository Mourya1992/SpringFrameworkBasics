package com.Microservice.Learing.OrderService.Common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Payment {

	private int id;
	private String Status;
	private String transactionId;
	private double price;
	private int OrderId;

	public Payment(int id, String status, String transactionId, double price, int orderId) {
		super();
		this.id = id;
		Status = status;
		this.transactionId = transactionId;
		this.price = price;
		OrderId = orderId;
	}

}
