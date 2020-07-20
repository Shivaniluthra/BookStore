package com.cg.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dao.OrderDao;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.InvalidQuantityException;
import com.cg.bookStore.exceptions.RecordAlreadyPresentException;
import com.cg.bookStore.exceptions.RecordNotFoundException;

@Service("bookstore")
@Transactional
public class BookStoreServiceImpl implements BookStoreService{

	@Autowired
	private BookStoreDao dao;
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<CartInformation> viewCartByCustomerId(int customerId) {
		List<CartInformation> reviewList=dao.viewCartByCustomerId(customerId);
		return reviewList;
	}
	
	
	@Override
	public boolean addCartItem(CartInformation cart) {
		return dao.addCartItem(cart);
	}
	
	@Override
	public boolean removeCartItem(int cartId) {
		CartInformation cart=dao.viewCartByCartId(cartId);
		return dao.removeCartItem(cart);
	}
	
	@Override
	public boolean clearCartByCustomerId(int customerId) {
		List<CartInformation> carts=dao.viewCartByCustomerId(customerId);
		int i=0;
		while(i<carts.size()) {
			dao.removeCartItem(carts.get(i));
			i++;
		}
		return true;
	}

	public String updateCart(int cartId,int quantity) throws InvalidQuantityException {
		CartInformation cart = dao.viewCartByCartId(cartId);
		if(quantity<0) {
			throw new InvalidQuantityException();
		}
		else
		{
			cart.setQuantity(quantity);
			dao.updateCartQuantity(cart);
		}
		return "Cart Updated";		
		
	}
	
	@Override
	public OrderInformation addOrder(OrderInformation order) throws RecordAlreadyPresentException {
		Optional<OrderInformation> newOrder = orderDao.findById(order.getOrderId());
		if(newOrder.isPresent()) {
			throw new RecordAlreadyPresentException();
		}
		else {
			orderDao.save(order);
			return order;
		}
	}

	@Override
	public OrderInformation viewOrderById(int id) {
		Optional<OrderInformation> order = orderDao.findById(id);
		if(!order.isPresent()) {
			throw new RecordNotFoundException();
		}
		else
			return order.get();
	}


	@Override
	public Iterable<OrderInformation> listAllOrder() {
		Iterable<OrderInformation> list = orderDao.findAll();
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	}
	
	@Override
	public List<OrderInformation> viewOrderByCustomerId(int customerId) {
		List<OrderInformation> list = dao.viewOrderByCustomerId(customerId);
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	}

	
}
