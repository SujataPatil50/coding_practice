package com.trade.exceptions;

import java.util.Date;


/**
 * This is the model to hold the exception details
 *
 */
public class ExceptionBody {
	
	private Date timestamp;
	
	private String errorMessage;
	
	public ExceptionBody(Date timestamp, String errorMessage) {
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
