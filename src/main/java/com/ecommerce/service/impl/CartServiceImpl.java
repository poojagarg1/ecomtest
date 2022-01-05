package com.ecommerce.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ecommerce.constants.Constant;
import com.ecommerce.enums.Role;
import com.ecommerce.exceptions.CartNotFoundException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.OrderItem;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	/*
	 * @Override public ResponseEntity<ApiResponse> updateAmount(Cart cart) { if
	 * (cart == null || cart.getUser() == null) throw new
	 * CartNotFoundException("Cart/User not found"); if
	 * (cart.getUser().getRole().equals(Role.employee.toString())) {
	 * cart.setCartTotal(cart.getCartTotal() * Discount.THIRTY.getValue());
	 * 
	 * } else if (cart.getUser().getRole().equals(Role.affiliate.toString())) {
	 * cart.setCartTotal(cart.getCartTotal() * Discount.THIRTY.getValue()); } return
	 * new ResponseEntity<ApiResponse>(new ApiResponse(true, "Net Payment Updated"),
	 * HttpStatus.OK);
	 * 
	 * }
	 */

	@Override
	public double getNetPayableAmount(Cart cart) {
		if (cart == null || cart.getUser() == null)
			throw new CartNotFoundException("Cart/User not found");
		double cartTotal = 0;
		for (OrderItem item : cart.getOrderItems()) {

			double itemPrice = item.getProduct().getPrice();
			if (item.getProduct().getCategory().getCategoryName() != Constant.groceries) {
			
				if (cart.getUser().getRole().toString().equals(Role.employee.toString())) {
				
					itemPrice = itemPrice - (itemPrice * 0.3);
				} else if (cart.getUser().getRole().toString().equals(Role.affiliate.toString())) {
					itemPrice = itemPrice - (itemPrice * 0.1);
				} else if (cart.getUser().getRole().toString().equals(Role.customer.toString())
						&& (cart.getUser().getSignupDate().getTime() - (new Date()).getTime())
								/ (1000l * 60 * 60 * 24 * 365) >= 2) {
					itemPrice = itemPrice - (itemPrice * 0.1);
				}

			}
			cartTotal = cartTotal + itemPrice;

		}


		double billDiscount = ((int) (cartTotal / 100) * 5);
		cartTotal = cartTotal - billDiscount;

		return cartTotal;
	}

}