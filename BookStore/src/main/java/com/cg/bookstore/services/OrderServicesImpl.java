package com.cg.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookstore.dao.CustomerInformationDao;
import com.cg.bookstore.dao.OrderDao;
import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.OrderInformation;
import com.cg.bookstore.exceptions.RecordAlreadyPresentException;
import com.cg.bookstore.exceptions.RecordNotFoundException;

@Service
public class OrderServicesImpl implements OrderServices{
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CustomerInformationDao custDao;

	@Override
	public OrderInformation addOrder(int id, OrderInformation order, String city, String fullName, int zipCode, String country, String phoneNumber) 
			throws RecordAlreadyPresentException {
		
		Optional<OrderInformation> newOrder = orderDao.findById(order.getOrderId());
		if(newOrder.isPresent()) {
			throw new RecordAlreadyPresentException("Record already present");
		}
		else {
			CustomerInformation modifyCustInfo= custDao.findById(id).get();
			modifyCustInfo.setFullName(fullName);
			modifyCustInfo.setZipCode(zipCode);
			modifyCustInfo.setCountry(country);
			modifyCustInfo.setCity(city);
			modifyCustInfo.setPhoneNumber(phoneNumber);
			orderDao.save(order);
			order.setCustomerDetails(modifyCustInfo);
			return order;
		}
	}


	@Override
	public CustomerInformation searchShippingInfo(int customerId) {
		Optional<CustomerInformation> customer = custDao.findById(customerId);
		if(!customer.isPresent()) {
			throw new RecordNotFoundException("Record not found");
		}
		else
			return customer.get();
	}
	
	
	
	
//	@Override
//	public String modifyShippingInfo(int id, Order order, String city) {
//		CustomerInformation modifyCustInfo= custDao.findById(id).get();
//		modifyCustInfo.setFullName(order.getCustomerDetails().getFullName());
//		modifyCustInfo.setZipCode(order.getCustomerDetails().getZipCode());
//		modifyCustInfo.setCountry(order.getCustomerDetails().getCountry());
//		modifyCustInfo.setCity(city);
//		modifyCustInfo.setPhoneNumber(order.getCustomerDetails().getPhoneNumber());
//		return "modified!";
//	}

}
