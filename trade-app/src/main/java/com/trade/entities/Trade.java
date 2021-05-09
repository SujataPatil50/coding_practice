package com.trade.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trades")
public class Trade {
	
	@Id
	@Column(name="Trade_Id")
	private String tradeId;
	
	private int version;
	
	@Column(name="Counter_Party_Id")
	private String counterPrtyId;
	
	@Column(name="Book_Id")
	private String bookId;
	
	@Column(name="Maturity_Date")
	private LocalDate maturityDate;
	
	@Column(name="Created_Date")
	private LocalDate createdDate;
	
	private String expired;
	
	

	public String getTradeId() {
		return tradeId;
	}



	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public String getCounterPrtyId() {
		return counterPrtyId;
	}



	public void setCounterPrtyId(String counterPrtyId) {
		this.counterPrtyId = counterPrtyId;
	}



	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public LocalDate getMaturityDate() {
		return maturityDate;
	}



	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public String getExpired() {
		return expired;
	}



	public void setExpired(String expired) {
		this.expired = expired;
	}



	@Override
	public String toString() {
		return "Trade [tardeId=" + tradeId + ", version=" + version + ", counterPrtyId=" + counterPrtyId + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + ", expired=" + expired
				+ "]";
	}

	

}
