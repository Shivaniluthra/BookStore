package com.cg.bookStore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.service.OrderServiceImpl;


@RestController
@RequestMapping
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@PostMapping("/addOrder")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<OrderInformation> addOrder(@RequestBody OrderInformation order) {
		
		if(order!=null) {
			orderService.addOrder(order);
			return new ResponseEntity<OrderInformation>(order, HttpStatus.OK);
		}
		else
			return new ResponseEntity("Cannot be null",HttpStatus.BAD_REQUEST);
	}	
	
	@GetMapping("/searchOrder/{orderId}")
	public ResponseEntity<OrderInformation> viewOrderById(@PathVariable("orderId") Integer id){
		OrderInformation order= orderService.viewOrderById(id);
		if(order!=null) {
			return new ResponseEntity<OrderInformation>(order, HttpStatus.OK);
		}
		else
			return new ResponseEntity("Order Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/viewAllOrder")
	public Iterable<OrderInformation> viewAllOrder(){
		Iterable<OrderInformation> orderList= orderService.listAllOrder();
		return orderList;
	}
}