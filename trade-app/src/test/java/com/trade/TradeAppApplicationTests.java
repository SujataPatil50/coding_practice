package com.trade;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trade.entities.Trade;
import com.trade.services.TradeHelper;


@SpringBootTest
class TradeAppApplicationTests {
	
	@Autowired
	private TradeHelper tradeHelper;;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testValidTradeVersion() {
		Trade newTrade = createTrade("T1", 1, LocalDate.now());
		Trade existingTrade = createTrade("T1", 2, LocalDate.now());
		Assertions.assertEquals(false, tradeHelper.validateVersion(newTrade, existingTrade));
		newTrade = createTrade("T1", 2, LocalDate.now());
		Assertions.assertEquals(true, tradeHelper.validateVersion(newTrade, existingTrade));
		
	}
	
	@Test
	void testValidMaturityDate() {
		Trade newTrade = createTrade("T1", 2, LocalDate.of(2014, 5, 17));
		
		Assertions.assertEquals(false, tradeHelper.validateMaturityDate(newTrade));
		
		newTrade = createTrade("T1", 2, LocalDate.of(2021, 12, 17));
		
		Assertions.assertEquals(true, tradeHelper.validateMaturityDate(newTrade));
		
	}
	
	private Trade createTrade(String tradeId,int version,LocalDate  maturityDate){
		Trade trade = new Trade();
		trade.setTradeId(tradeId);
		trade.setBookId(tradeId+"B1");
		trade.setVersion(version);
		trade.setCounterPrtyId(tradeId+"Cpty");
		trade.setMaturityDate(maturityDate);
		trade.setExpired("N");
		return trade;
	}
}
