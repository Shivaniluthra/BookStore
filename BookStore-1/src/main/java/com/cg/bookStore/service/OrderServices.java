package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;

public interface OrderServices {
	public OrderInformation addOrder(OrderInformation order) throws RecordAlreadyPresentException;
	public OrderInformation viewOrderById(int id);
	public Iterable<OrderInformation> listAllOrder();
	public List<OrderInformation> viewOrderByCustomerId(int customerId);
}
