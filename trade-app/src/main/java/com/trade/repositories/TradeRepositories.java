package com.trade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.entities.Trade;

@Repository
public interface TradeRepositories extends JpaRepository<Trade, String>{

}
