package com.cg.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookstore.dao.CustomerInformationDao;
import com.cg.bookstore.dao.OrderDao;
import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.Order;
import com.cg.bookstore.exceptions.RecordAlreadyPresentException;

@Service
public class OrderServicesImpl implements OrderServices{
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CustomerInformationDao custDao;

	
	@Override
	public Order modifyShippingInfo(Order order) {
		Order modifyOrder= orderDao.findById(order.getOrderId()).get();
		CustomerInformation modifyCustInfo= custDao.findById(order.getCustomerDetails().getCustomerId()).get();
		modifyCustInfo.setFullName(order.getCustomerDetails().getFullName());
		modifyCustInfo.setZipCode(order.getCustomerDetails().getZipCode());
		modifyCustInfo.setCountry(order.getCustomerDetails().getCountry());
		modifyCustInfo.setCity(order.getCustomerDetails().getCity());
		modifyCustInfo.setPhoneNumber(order.getCustomerDetails().getPhoneNumber());
		modifyOrder.setShippingAddress(order.getShippingAddress());
		return modifyOrder;
	}


	@Override
	public Order addOrder(Order order) {
		Optional<Order> newOrder = orderDao.findById(order.getOrderId());
		try {
			if(newOrder.isPresent()) {
				throw new RecordAlreadyPresentException("Record already present");
			}
			else
				orderDao.save(order);
		}
		catch(RecordAlreadyPresentException e) {
					System.out.println("Duplicacy");
		}
		return order;
	}
	
}
