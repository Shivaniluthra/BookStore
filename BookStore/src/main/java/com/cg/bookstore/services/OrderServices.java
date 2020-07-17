package com.cg.bookstore.services;

import org.springframework.http.ResponseEntity;

import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.OrderInformation;

public interface OrderServices {
	public OrderInformation addOrder(int id, OrderInformation order, String city, String fullName, int zipCode, String country, String phoneNumber);
	public CustomerInformation searchShippingInfo(int customerId);

}
