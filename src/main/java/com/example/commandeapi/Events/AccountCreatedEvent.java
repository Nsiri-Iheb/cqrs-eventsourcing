package com.example.commandeapi.Events;

import com.example.commandeapi.Enum.AccountState;

public class AccountCreatedEvent extends BaseEvent<String> {
	public AccountCreatedEvent(  String id,double intialbalance, String currency) {
		super(id);
		this.intialbalance = intialbalance;
		this.currency = currency;
		//this.accountState = accountState;
	}
	public AccountCreatedEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	private double intialbalance;
	private String currency;
	private AccountState accountState;
	public double getIntialbalance() {
		return intialbalance;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public AccountState getAccountState() {
		return accountState;
	}
	

}
