package com.Microservice.Learing.PaymentService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String Status;
	private String transactionId;
	private int orderId;
	private double price;

	public Payment(int id, String status, String transactionId, int orderId, double price) {
		super();
		this.id = id;
		Status = status;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.price = price;
	}

}
