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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.exceptions.BookNotFoundException;
import com.cg.bookStore.exceptions.RecordNotFoundException;
import com.cg.bookStore.service.BookStoreService;

@CrossOrigin("*")
@RestController
public class BookStoreController {
	
	@Autowired
	public BookStoreService service;
	
	
	@GetMapping("/viewcartbycustomerid/{customerid}")
	public List<CartInformation> viewCartByCustomerId(@PathVariable("customerid") int customerId) {
			return service.viewCartByCustomerId(customerId);
	}
	
	@CrossOrigin
	@PostMapping("/addbooktocart/{bookid}/{customerid}/{status}")
	public String addBookToCart(@PathVariable("bookid") int bookId, @PathVariable("customerid")int customerId,
			@PathVariable("status")String status) throws BookNotFoundException {
		return service.addBookToCart(bookId, customerId, status);
	}
	
	@CrossOrigin
	@GetMapping("/viewallbooks")
	public List<BookInformation> viewdDiagnosisCentre() throws RecordNotFoundException {
		return service.viewBooks();
	}
	
	@DeleteMapping("/removecartitem/{cartid}")
	public boolean removeCartItem(@PathVariable("cartid") int cartId, HttpServletRequest request) {
		return service.removeCartItem(cartId);
	}
	
	@DeleteMapping("/clearcartbycustomerid/{customerid}")
	public boolean clearCartByCustomerId(@PathVariable("customerid") int customerId, HttpServletRequest request) {
		return service.clearCartByCustomerId(customerId);
	}
	
	
}
