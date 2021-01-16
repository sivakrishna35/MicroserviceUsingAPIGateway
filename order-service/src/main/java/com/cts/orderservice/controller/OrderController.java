package com.cts.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.orderservice.common.Payment;
import com.cts.orderservice.common.TransactionRequest;
import com.cts.orderservice.common.TransactionResponse;
import com.cts.orderservice.entity.Order;
import com.cts.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
		
		
		return orderService.saveOrder(request);
	}

}
