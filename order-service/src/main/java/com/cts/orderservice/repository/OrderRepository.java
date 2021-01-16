package com.cts.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
