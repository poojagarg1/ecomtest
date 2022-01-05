package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;
import com.ecommerce.service.impl.CartServiceImpl;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/netPayableAmount")
	public double netPayableAmount(@RequestBody Cart cart) {
		return cartService.getNetPayableAmount(cart);

	}

}
