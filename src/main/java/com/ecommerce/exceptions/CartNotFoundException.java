package com.ecommerce.exceptions;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException(String exception) {
		super(exception);
	}

}
