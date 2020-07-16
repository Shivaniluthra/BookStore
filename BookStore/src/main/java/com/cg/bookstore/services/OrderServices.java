package com.cg.bookstore.services;

import org.springframework.http.ResponseEntity;

import com.cg.bookstore.entities.Order;

public interface OrderServices {
	public Order addOrder(Order order);
	public Order modifyShippingInfo(Order order);

}
