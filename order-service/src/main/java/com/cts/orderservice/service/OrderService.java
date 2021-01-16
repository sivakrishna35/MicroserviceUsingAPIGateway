package com.cts.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.orderservice.common.Payment;
import com.cts.orderservice.common.TransactionRequest;
import com.cts.orderservice.common.TransactionResponse;
import com.cts.orderservice.entity.Order;
import com.cts.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest request){
		String paymetResponse = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResult = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		paymetResponse = paymentResult.getPaymentStatus().equals("Success") ? "Payment process successful, order was placed":"payment process failed in payment API";
		if(paymentResult.getPaymentStatus().equals("Success")){
			orderRepository.save(order);
		}
		
		return new TransactionResponse(order, paymentResult.getAmount(), paymentResult.getTransactionId(), paymetResponse);
	}
}
