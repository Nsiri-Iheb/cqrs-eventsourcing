package com.example.commandeapi.Events;

public class AccountCreditedEvent extends BaseEvent<String> {
	public AccountCreditedEvent(String id, double amount, String currency) {
		super(id);
		this.amount = amount;
		this.currency = currency;
	}
	private double amount;
	private String currency;
	public double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	
	

}
