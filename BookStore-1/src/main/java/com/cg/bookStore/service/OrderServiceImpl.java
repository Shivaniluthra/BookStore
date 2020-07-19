package com.cg.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dao.OrderDao;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.exceptions.RecordNotFoundException;

@Service
public class OrderServiceImpl implements OrderServices {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	BookStoreDao bookDao;

	@Override
	public OrderInformation addOrder(OrderInformation order) throws RecordAlreadyPresentException {
		Optional<OrderInformation> newOrder = orderDao.findById(order.getOrderId());
		if(newOrder.isPresent()) {
			throw new RecordAlreadyPresentException();
		}
		else {
			orderDao.save(order);
			return order;
		}
	}

	@Override
	public OrderInformation viewOrderById(int id) {
		Optional<OrderInformation> order = orderDao.findById(id);
		if(!order.isPresent()) {
			throw new RecordNotFoundException();
		}
		else
			return order.get();
	}


	@Override
	public Iterable<OrderInformation> listAllOrder() {
		Iterable<OrderInformation> list = orderDao.findAll();
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	}
	
	@Override
	public List<OrderInformation> viewOrderByCustomerId(int customerId) {
		List<OrderInformation> list = bookDao.viewOrderByCustomerId(customerId);
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	}

	

}
