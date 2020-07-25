package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.exceptions.InvalidQuantityException;
import com.cg.bookStore.service.BookStoreService;

@RestController
@CrossOrigin("*")
public class UpdateCartController {

	@Autowired
	private BookStoreService service;
	
	@PutMapping("/update/{cartId}/{quantity}")
	public boolean updateCart(@PathVariable("cartId") int cartId, @PathVariable("quantity") int quantity) throws InvalidQuantityException {
		service.updateCart(cartId, quantity);
		return true;	
	}
}
