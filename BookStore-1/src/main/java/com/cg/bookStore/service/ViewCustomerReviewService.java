package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.CustomerReview;

public interface ViewCustomerReviewService {
	
	public List<CustomerReview> viewReviewsByBookId(int bookId);

}
