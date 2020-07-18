package com.cg.bookStore.service;

import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.OrderInformation;

public interface OrderServices {
	public OrderInformation addOrder(int id, OrderInformation order);
	public CustomerInformation searchShippingInfo(int customerId);
	public OrderInformation viewOrderById(int id);
	public Iterable<OrderInformation> listAllOrder();
}
