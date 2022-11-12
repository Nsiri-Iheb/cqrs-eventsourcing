package com.example.commandeapi.command;

public class DebitAccountCommande extends BaseCommande<String> {
	private double amount;
	private String Currency;
	public DebitAccountCommande(String id,double amount,String currency) {
		super(id);
		this.amount=amount;
		this.Currency=currency;
	}
	public double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return Currency;
	}
	
	
   
}
