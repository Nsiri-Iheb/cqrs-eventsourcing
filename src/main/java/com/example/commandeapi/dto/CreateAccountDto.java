package com.example.commandeapi.dto;

public class CreateAccountDto {
	public CreateAccountDto(double intialBalance, String currency) {
		super();
		this.intialBalance = intialBalance;
		this.currency = currency;
	}
	public CreateAccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private double intialBalance;
	private String currency;
	public double getIntialBalance() {
		return intialBalance;
	}
	public void setIntialBalance(double intialBalance) {
		this.intialBalance = intialBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	};
	

}
