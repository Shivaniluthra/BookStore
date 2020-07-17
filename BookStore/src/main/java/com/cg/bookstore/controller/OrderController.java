package com.cg.bookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.OrderInformation;
import com.cg.bookstore.exceptions.RecordAlreadyPresentException;
import com.cg.bookstore.exceptions.RecordNotFoundException;
import com.cg.bookstore.services.OrderServicesImpl;

@RestController
@RequestMapping
public class OrderController {
	
	@Autowired
	OrderServicesImpl orderService;
	
	@PostMapping("/addOrder/{custId}")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<OrderInformation> addOrder(@RequestBody OrderInformation order, @PathVariable("custId") int id, 
			@RequestParam(name="city") String city, @RequestParam(name = "country") String country,
			@RequestParam(name = "phoneNumber") String phoneNumber, @RequestParam(name = "fullName") String fullName,
			@RequestParam(name = "zipCode") Integer zipCode) {
		
		if(order!=null) {
			orderService.addOrder(id, order, city, fullName, zipCode, country, phoneNumber);
			return new ResponseEntity<OrderInformation>(order, HttpStatus.OK);
		}
		else
			return new ResponseEntity("Cannot be null",HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/searchShippingInfo/{customerId}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<CustomerInformation> searchShippingInfo(@PathVariable int customerId){
		CustomerInformation searchCustomer = orderService.searchShippingInfo(customerId);
		if(searchCustomer==null) {
			return new ResponseEntity("No information present", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<CustomerInformation>(searchCustomer, HttpStatus.OK);
		}
	}
	
	
	
//	@PutMapping("/modifyShippingInfo")
//	public ResponseEntity<Order> modifyShippingInfo(@RequestBody Order order){
//		Order response= orderService.modifyShippingInfo(order);
//		if(order!=null) {
//			return new ResponseEntity<Order>(response,HttpStatus.OK); 
//		}
//		else 
//			return new ResponseEntity("Information not updated!", HttpStatus.BAD_REQUEST);
//	}
	
}
