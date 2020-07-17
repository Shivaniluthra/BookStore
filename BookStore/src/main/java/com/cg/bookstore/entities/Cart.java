//package com.cg.bookstore.entities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "bookstore_cart")
//public class Cart {
//	
//	@Id
//	@Column(name="cart_id")
//	private Integer cartId;
//	
//	@OneToMany
//	@JoinColumn(name = "cart_id")
//	private List<BookInformation> bookList = new ArrayList<BookInformation>();
//	
//	@OneToOne
//	private OrderInformation orderInfo;
//	
//
//}
