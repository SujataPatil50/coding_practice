package com.trade.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.entities.Trade;
import com.trade.exceptions.InvalidTradeVersionException;
import com.trade.repositories.TradeRepositories;

/**
 * 
 * This is the Trade service class which provide APIs to work with trades and db operations
 *
 */

@Service
public class TradeService {
	
	@Autowired
	private TradeHelper tradeHelper;
	
	@Autowired
	private TradeRepositories tradeRepo;

	
	public List<Trade> getTrades() {
		List<Trade> trades= new ArrayList<>();
		trades = tradeRepo.findAll();
		
		return trades;
	}

	
	public Trade getTrade(String tradeId) {
		Optional<Trade> trade = tradeRepo.findById(tradeId);
		
		if(trade.isPresent()) {
			return trade.get();
		}
		return null;
	}


	public void addTrade(Trade trade) {
		if(tradeHelper.validateMaturityDate(trade)) {
			trade.setCreatedDate(LocalDate.now());
			tradeRepo.save(trade);
		}
	}


	public void updateTrade(Trade newTrade) {
		Optional<Trade> existingTrade = tradeRepo.findById(newTrade.getTradeId());
		
		if(existingTrade.isPresent()) {
			boolean isValidVersion = tradeHelper.validateVersion(newTrade, existingTrade.get());
			if(isValidVersion)
				tradeRepo.save(newTrade);
			else {
				throw new InvalidTradeVersionException("Received version is lower than existing version.");
			}
		}
		
	}


	public void updateExpiryFlag() {
		tradeRepo.findAll().stream().forEach(trade-> {
			if(!tradeHelper.validateMaturityDate(trade)) {
				trade.setExpired("Y");
				tradeRepo.save(trade);
			}
		});
		
	}
	
	

}
