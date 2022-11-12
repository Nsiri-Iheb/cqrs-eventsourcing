package com.example.commandeapi.dto;

public class DebitedAccountDto {
	private String id;
	private double amount;
	private String currency;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getId() {
		return id;
	}

}
