package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.CustomerReview;

public interface BookStoreDao {
	
	public List<CustomerReview> viewReviewsByBookId(int bookId);

}
