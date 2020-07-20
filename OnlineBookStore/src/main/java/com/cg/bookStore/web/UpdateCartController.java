package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.UpdateCartDto;
import com.cg.bookStore.exceptions.InvalidQuantityException;
import com.cg.bookStore.service.BookStoreService;

@RestController
public class UpdateCartController {

	@Autowired
	private BookStoreService service;
	
	@PostMapping("/update")
	public boolean updateCart(@RequestBody UpdateCartDto dto) throws InvalidQuantityException {
		service.updateCart(dto.getCartId(), dto.getQuantityToIncrease());
		return true;	
	}
	
	@GetMapping("/add")
	public String getBooks() {
		return "Shiva";
	}
}
