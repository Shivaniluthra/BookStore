package com.cg.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.OrderDao;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.exceptions.RecordNotFoundException;

@Service
public class OrderServiceImpl implements OrderServices {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public OrderInformation addOrder(OrderInformation order) {
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
//			int qty=0;
//			int size = order.getCart().size();
//			for(int i=0;i<size;i++) {
//				qty = qty+ order.getCart().get(i).getQuantity();
//			}
//			order.setQuantity(qty);
//			order.setTotalPrice();
			orderDao.save(order);
			return order;
		}
	}

	@Override
	public OrderInformation viewOrderById(int id) {
		Optional<OrderInformation> order = orderDao.findById(id);
		if(!order.isPresent()) {
			throw new RecordNotFoundException("Record Not Found");
		}
		else
			return order.get();
	}


	@Override
	public Iterable<OrderInformation> listAllOrder() {
		return orderDao.findAll();
	}

	

}
