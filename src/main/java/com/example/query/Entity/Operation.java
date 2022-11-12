package com.example.query.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.commandeapi.Enum.OperationType;
@Entity
public class Operation implements Serializable {
	public Operation(Long id, Date dateoperation, double amount, Account account,OperationType operationType) {
		super();
		this.id = id;
		this.dateoperation = dateoperation;
		this.amount = amount;
		this.account = account;
		this.operationType=operationType;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateoperation;
	private double amount;
	@ManyToOne
	private Account   account;
	@Enumerated(EnumType.STRING)
	private OperationType operationType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

}
