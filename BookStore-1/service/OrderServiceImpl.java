package com.cg.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookStore.dao.OrderDao;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;

public class OrderServiceImpl implements OrderServices {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public OrderInformation addOrder(int id, OrderInformation order) {
		Optional<OrderInformation> newOrder = orderDao.findById(order.getOrderId());
		if(newOrder.isPresent()) {
			throw new RecordAlreadyPresentException("Record already there");
		}
		else {
//			order.setCity(order.getCustomer().getCity());
//			order.setCountry(order.getCustomer().getCountry());
//			order.setShippingAddress(order.getCustomer().getAddress());
//			order.setZipCode(order.getCustomer().getZipCode());
//			order.setRecipientName(order.getCustomer().getFullName());
			int qty=0;
			int size = order.getCartId().size();
			for(int i=0;i<size;i++) {
				qty = qty+ order.getCartId().get(i).getQuantity();
			}
			order.setQuantity(qty);
			orderDao.save(order);
			return order;
		}
	}

	@Override
	public CustomerInformation searchShippingInfo(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderInformation viewOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<OrderInformation> listAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
