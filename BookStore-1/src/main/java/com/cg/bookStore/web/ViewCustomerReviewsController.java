package com.cg.bookStore.web;

import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.service.ViewCustomerReviewService;

@RestController
public class ViewCustomerReviewsController {
	
	@Autowired
	public ViewCustomerReviewService service;
	
	
	@CrossOrigin
	@GetMapping("/viewcustomerreviewsbybookid/{bookid}")
	public List<CustomerReview> viewReviewsByBookId(@PathVariable("bookid") int bookId,
			HttpServletRequest request) {
			return service.viewReviewsByBookId(bookId);
	}

}
