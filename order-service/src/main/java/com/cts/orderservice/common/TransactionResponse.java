package com.cts.orderservice.common;

import com.cts.orderservice.entity.Order;

public class TransactionResponse {
	
	private Order order;
	private double amount;
	private String transactionId;
	private String paymentResponse;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getPaymentResponse() {
		return paymentResponse;
	}
	public void setPaymentResponse(String paymentResponse) {
		this.paymentResponse = paymentResponse;
	}
	public TransactionResponse(Order order, double amount, String transactionId,
			String paymentResponse) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.paymentResponse = paymentResponse;
	}
	
	
	

}
