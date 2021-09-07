package com.Microservice.Learing.OrderService.Common;

import com.Microservice.Learing.OrderService.Entity.OrderDetails;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class TransactionRequest {

	private OrderDetails order;
	private Payment payment;
	public TransactionRequest(OrderDetails order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}
	
	

}
