package com.project.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7182905945314218841L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}
}
