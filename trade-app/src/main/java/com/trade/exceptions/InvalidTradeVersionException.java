package com.trade.exceptions;


/**
 * This API is to handle the Exception for trade invalid version
 *
 */
public class InvalidTradeVersionException extends RuntimeException {
	
	private String message;
	
	public InvalidTradeVersionException(String message) {
		super(message);
		
		this.message = message;
	}	

}
