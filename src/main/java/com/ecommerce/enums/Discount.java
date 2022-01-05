package com.ecommerce.enums;

public enum Discount {
	THIRTY(30), TEN(10), FIVE(5);

	private final int value;

	Discount(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}
}