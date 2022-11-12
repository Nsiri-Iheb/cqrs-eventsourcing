package com.example.query.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.commandeapi.Enum.AccountState;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
@Entity
@XStreamAlias("root")
public class Account implements Serializable {
	public Account(String id, double intialbalance, AccountState accountState, String currency,
			List<Operation> operations) {
		super();
		this.id = id;
		this.intialbalance = intialbalance;
		this.accountState = accountState;
		this.currency = currency;
		this.operations = operations;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private String id;
	private double intialbalance;
	@Enumerated(EnumType.STRING)
	private AccountState accountState;
	private String currency;
	@OneToMany(mappedBy ="account")

	   @XStreamImplicit(itemFieldName = "type")
	public Collection<Operation> operations;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getIntialbalance() {
		return intialbalance;
	}
	public void setIntialbalance(double intialbalance) {
		this.intialbalance = intialbalance;
	}
	public AccountState getAccountState() {
		return accountState;
	}
	public void setAccountState(AccountState accountState) {
		this.accountState = accountState;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
