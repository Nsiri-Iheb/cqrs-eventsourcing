package com.example.commandeapi.command;



public class CreateAccountCommand  extends BaseCommande<String>{
	private double intialbalance;
	private String currency;
	public CreateAccountCommand(  String  id ,double intialbalance,String currency){
		super(id);
		this.intialbalance=intialbalance;
		this.currency=currency;
	}
	public String getCurrency() {
		return currency;
	}
	public double getIntialbalance() {
		return intialbalance;
	}
	
	

}
