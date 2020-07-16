package com.cg.bookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Order;
import com.cg.bookstore.exceptions.RecordAlreadyPresentException;
import com.cg.bookstore.services.OrderServicesImpl;

@RestController
@RequestMapping
public class OrderController {
	
	@Autowired
	OrderServicesImpl orderService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		if(order!=null) {
			orderService.addOrder(order);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/modifyShippingInfo")
	public ResponseEntity<Order> modifyShippingInfo(@RequestBody Order order){
		Order response= orderService.modifyShippingInfo(order);
		if(order!=null) {
			return new ResponseEntity<Order>(response,HttpStatus.OK); 
		}
		else 
			return new ResponseEntity("Information not updated!", HttpStatus.BAD_REQUEST);
	}
	
}
