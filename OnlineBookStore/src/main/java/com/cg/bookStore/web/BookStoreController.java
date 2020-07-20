package com.cg.bookStore.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.service.BookStoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	public BookStoreService service;
	
	@CrossOrigin
	@GetMapping("/viewcartbycustomerid/{customerid}")
	public List<CartInformation> viewCartByCustomerId(@PathVariable("customerid") int customerId,
			HttpServletRequest request) {
			return service.viewCartByCustomerId(customerId);
	}
	
	@CrossOrigin
	@PostMapping("/addcartitem")
	public boolean addCartItem(@RequestBody CartInformation cart, 
			HttpServletRequest request) {
			return service.addCartItem(cart);
	}
	
	@CrossOrigin
	@DeleteMapping("/removecartitem/{cartid}")
	public boolean removeCartItem(@PathVariable("cartid") int cartId, HttpServletRequest request) {
		return service.removeCartItem(cartId);
	}
	
	@CrossOrigin
	@DeleteMapping("/clearcartbycustomerid/{customerid}")
	public boolean clearCartByCustomerId(@PathVariable("customerid") int customerId, HttpServletRequest request) {
		return service.clearCartByCustomerId(customerId);
	}
	
	
}
