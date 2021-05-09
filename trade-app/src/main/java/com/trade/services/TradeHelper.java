package com.trade.services;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.trade.entities.Trade;


/**
 * This API holds all the validation related logic for trades
 *
 */
@Component
public class TradeHelper {

	/**
	 * This method validates version of trade. It returns true if version is same or greater than existing trade. 
	 * else return false
	 * @param newTrade
	 * @param existingTrade
	 * @return boolean
	 */
	public boolean validateVersion(Trade newTrade, Trade existingTrade) {
		if(newTrade.getVersion() >= existingTrade.getVersion()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	/** 
	 * This method validate the maturity date is if future date or not. If date is old date then return false.
	 * Else returns true.
	 * @param trade
	 * @return boolean
	 */
	public boolean validateMaturityDate(Trade trade) {
		 if(trade.getMaturityDate().isBefore(LocalDate.now())) {
			 return false;
		 }
		 else {
			 return true;
		 }
	}
	

	
}
