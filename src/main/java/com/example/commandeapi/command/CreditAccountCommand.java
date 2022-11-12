package com.example.commandeapi.command;

public class CreditAccountCommand extends BaseCommande<String> {
	public CreditAccountCommand(String id,double amount,String currency) {
	super(id);
	this.amount=amount;
	this.currency=currency;
	}
	public double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	private double amount;
	private  String currency;

}
