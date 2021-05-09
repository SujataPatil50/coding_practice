package com.trade.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trade.entities.Trade;
import com.trade.services.TradeService;

@RestController
public class TradeController {
	
	@Autowired
	private TradeService tradeService;
	
	@GetMapping("/trades")
	public List<Trade> getTrades() {
		
		List<Trade> trades = new ArrayList<Trade>();
		trades = tradeService.getTrades();
		
		return trades;
		
	}
	
	@GetMapping("trades/{id}")
	public Trade getTrade(@PathVariable("id") String tradeId) {
		Trade trade = tradeService.getTrade(tradeId);
		
		return trade;
	}
	
	@PostMapping("/trades")
	public void addTrade(@RequestBody Trade trade) {
		tradeService.addTrade(trade);
	}
	
	@PutMapping("/trades")
	public void updateTrade(@RequestBody Trade trade) {
		tradeService.updateTrade(trade);
	}

}
