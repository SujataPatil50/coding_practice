package com.trade.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is the custom class to handle the Exceptions
 *
 */
@ControllerAdvice
public class TradeCustomExceptions extends ResponseEntityExceptionHandler{ 
	
	@ExceptionHandler(InvalidTradeVersionException.class)
	public ResponseEntity<Object> handleInvalidVersionException(InvalidTradeVersionException exp) {
		ExceptionBody exception = new ExceptionBody(new Date(), exp.getMessage());
		return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE); 
	}
	
	@ExceptionHandler(InvalidTradeMaturityDateException.class)
	public ResponseEntity<Object> handleInvalidMaturityDateException(InvalidTradeMaturityDateException exp) {
		ExceptionBody exception = new ExceptionBody(new Date(), exp.getMessage());
		return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE); 
	}

}
