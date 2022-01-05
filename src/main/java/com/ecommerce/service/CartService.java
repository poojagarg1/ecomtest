package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;

public interface CartService {

	double getNetPayableAmount(Cart cart);

}
