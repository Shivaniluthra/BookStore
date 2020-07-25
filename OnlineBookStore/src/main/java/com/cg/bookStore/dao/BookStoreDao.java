package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.OrderInformation;

public interface BookStoreDao {
	
	public List<CartInformation> viewCartByCustomerId(int customerId);

	public boolean removeCartItem(CartInformation cart);

	public CartInformation viewCartByCartId(int cartId);

	public boolean updateCartQuantity(CartInformation cart);

	public List<OrderInformation> viewOrderByCustomerId(int customerId);

	public String addBookToCart(CartInformation cart);
	
	public List<BookInformation> viewBooks();
	
	public BookInformation getBook(int bookId);


}
