package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.entities.OrderInformation;

public interface BookStoreDao {
	
	public List<CustomerReview> viewReviewsByBookId(int bookId);

	public List<OrderInformation> viewOrderByCustomerId(int customerId);

}
