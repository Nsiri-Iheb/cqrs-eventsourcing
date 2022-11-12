package com.example.service;

import java.util.List;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repositry.AccountRepositry;
import com.example.Repositry.OperationReposiry;
import com.example.commandeapi.Enum.OperationType;
import com.example.commandeapi.Events.AccountCreatedEvent;
import com.example.commandeapi.Events.AccountCreditedEvent;
import com.example.commandeapi.Events.AccountDebitedEvent;
import com.example.commandeapi.dto.GetAllAccountDto;
import com.example.query.Entity.Account;
import com.example.query.Entity.Operation;

@Service
public class AccountServiceHandeler {
	@Autowired
	AccountRepositry accountRepositry;
	@Autowired
	OperationReposiry operationReposiry;
	@EventHandler
	public void on(AccountCreatedEvent event) {
		Account account=new  Account();
		account.setAccountState(event.getAccountState());
		account.setCurrency(event.getCurrency());
		account.setIntialbalance(event.getIntialbalance());
	//	account.setOperations(null);
		account.setId(event.getId());
	
		accountRepositry.save(account);
	}
	@EventHandler
	public  void on(AccountDebitedEvent accountDebitedEvent) {
		Account account=accountRepositry.findById(accountDebitedEvent.getId()).get();
		Operation operation=new  Operation();
		operation.setAmount(accountDebitedEvent.getAmount()-account.getIntialbalance());
		operation.setOperationType(OperationType.Debit);
		operation.setAccount(account);
		operationReposiry.save(operation);
		accountRepositry.save(account);
	}
	@EventHandler
	public void on(AccountCreditedEvent accountCreatedEvent) {
		Account account=accountRepositry.findById(accountCreatedEvent.getId()).get();	
		Operation operation=new  Operation();
		operation.setAmount(accountCreatedEvent.getAmount()-account.getIntialbalance());
		operation.setOperationType(OperationType.Credit);
		operation.setAccount(account);
		operationReposiry.save(operation);
		accountRepositry.save(account);
		}
	@QueryHandler
	public List<Account> getAllAccount(GetAllAccountDto getAllAccountDto){
		return accountRepositry.findAll();
	}

}
