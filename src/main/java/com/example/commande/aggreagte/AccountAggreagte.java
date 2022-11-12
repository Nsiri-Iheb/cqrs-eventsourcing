package com.example.commande.aggreagte;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.Exception.BalanceNotSufficientException;
import com.example.commandeapi.Enum.AccountState;
import com.example.commandeapi.Events.AccountCreatedEvent;
import com.example.commandeapi.Events.AccountCreditedEvent;
import com.example.commandeapi.Events.AccountDebitedEvent;
import com.example.commandeapi.command.CreateAccountCommand;
import com.example.commandeapi.command.CreditAccountCommand;
import com.example.commandeapi.command.DebitAccountCommande;


@Aggregate
public class AccountAggreagte {
	
	public AccountAggreagte(String accountId, double intialbalance, String currency, AccountState accountState) {
		super();
		this.accountId = accountId;
		this.intialbalance = intialbalance;
		this.currency = currency;
		this.accountState = accountState;
	}
	@AggregateIdentifier
	private String accountId;
	private double intialbalance;
	private  String currency;
	private AccountState accountState;
	public AccountState getAccountState() {
		return accountState;
	}
	public String getAccountId() {
		return accountId;
	}
	
	public double getIntialbalance() {
		return intialbalance;
	} 
	public String getCurrency() {
		return currency;
	}
	public AccountAggreagte() {
		
		// TODO Auto-generated constructor stub
		// obligatoire par axon
	}
	@CommandHandler
	public AccountAggreagte(CreateAccountCommand accountCommand) {
		if(accountCommand.getIntialbalance()<0) {
			throw new RuntimeException("imposiible");
		}else {
			AggregateLifecycle.apply(new AccountCreatedEvent(accountCommand.getId(), accountCommand.getIntialbalance(), accountCommand.getCurrency()));
		}
		
	}
	@EventSourcingHandler
	public void on(AccountCreatedEvent event) {
		
		this.accountId = event.getId();
		
		this.intialbalance = event.getIntialbalance();
		this.currency = event.getCurrency();
		this.accountState = AccountState.Created;	}
	@CommandHandler
	public void  handeler (DebitAccountCommande commande) {
		if(commande.getAmount()<0) {
			throw new RuntimeException("imposiible");
		} else if(this.intialbalance<commande.getAmount()) {
			throw new BalanceNotSufficientException("charger votre compte!");
		
		} else {
			AggregateLifecycle.apply(new AccountDebitedEvent(commande.getId(), commande.getAmount(), commande.getCurrency()));		}
		
		
		
	}
	@EventSourcingHandler
	public  void on(AccountDebitedEvent accountDebitedEvent) {
		//this.accountId=accountDebitedEvent.getId();
		this.intialbalance=-accountDebitedEvent.getAmount();
		//this.currency=accountDebitedEvent.getCurrency();
		
	}
	@CommandHandler
	public void handel(CreditAccountCommand creditAccountCommand) {
		if(creditAccountCommand.getAmount()<0) {
			throw new BalanceNotSufficientException("imposiible amount doit etre positive");
		}else {
			AggregateLifecycle.apply(new AccountCreatedEvent(creditAccountCommand.getId(), creditAccountCommand.getAmount(), creditAccountCommand.getCurrency()));
		}}
    @EventSourcingHandler
	public  void handell(AccountCreditedEvent accountEvent) {
			//this.accountId=accountDebitedEvent.getId();
			this.intialbalance=+accountEvent.getAmount();			
			//this.currency=accountDebitedEvent.getCurrency();
			
		}
	}
	
		
	



