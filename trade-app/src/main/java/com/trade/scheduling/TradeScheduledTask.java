package com.trade.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.trade.services.TradeService;

/**
 * This API schedule the task every day to update the Trade Expired flag based on the maturity date. 
 *
 */
@Component
public class TradeScheduledTask {
	
	@Autowired
	private TradeService tradeService;
	
	@Scheduled(cron = "${trade.schedule.expiry-flag}")
	public void updateTradeExpierFlag() {
		tradeService.updateExpiryFlag();
		
	}
}
