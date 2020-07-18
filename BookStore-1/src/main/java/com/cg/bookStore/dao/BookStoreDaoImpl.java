package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.BookInformation;
import com.cg.bookStore.entities.CustomerReview;

@Repository
public class BookStoreDaoImpl implements BookStoreDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CustomerReview> viewReviewsByBookId(int bookId) {
		String jpql = "from CustomerReview cr inner join fetch cr.book b where b.bookId=:bookid";
		TypedQuery<CustomerReview> query = em.createQuery(jpql, CustomerReview.class);
		query.setParameter("bookid", bookId);
		return query.getResultList();
	}
		
}
