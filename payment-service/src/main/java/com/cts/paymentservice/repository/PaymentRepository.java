package com.cts.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
