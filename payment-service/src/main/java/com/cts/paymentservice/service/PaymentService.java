package com.cts.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.paymentservice.entity.Payment;
import com.cts.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment){
		payment.setPaymentStatus(paymentStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		
		return paymentRepository.save(payment);
	}
	
	//It should be come from 3rd party payment gate-way
	public String paymentStatus(){
		return new Random().nextBoolean() ? "Success" : "False";
	}
}
