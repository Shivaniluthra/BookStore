package com.cg.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.CustomerReview;

@Service("customerreviewser")
@Transactional
public class ViewCustomerReviewServiceImpl implements ViewCustomerReviewService{

	@Autowired
	private BookStoreDao dao;
	
	@Override
	public List<CustomerReview> viewReviewsByBookId(int bookId) {
		List<CustomerReview> reviewList=dao.viewReviewsByBookId(bookId);
		return reviewList;
	}

	

}
