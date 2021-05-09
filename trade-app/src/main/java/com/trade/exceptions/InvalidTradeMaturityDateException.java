package com.trade.exceptions;


/**
 * This API is to handle the Exception for maturity date validation
 *
 */
public class InvalidTradeMaturityDateException extends RuntimeException {
	
	private String message;
	
	public InvalidTradeMaturityDateException(String message) {
		super(message);
		
		this.message = message;
	}	

}
