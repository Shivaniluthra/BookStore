package com.cg.bookStore.dto;

public class UpdateCartDto {

	private int cartId;
	private int quantityToIncrease;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getQuantityToIncrease() {
		return quantityToIncrease;
	}
	public void setQuantityToIncrease(int quantityToIncrease) {
		this.quantityToIncrease = quantityToIncrease;
	}
	
	
}
