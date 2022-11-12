package com.example.commandeapi.queries;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.commandeapi.dto.GetAccountQueryId;
import com.example.commandeapi.dto.GetAllAccountDto;
import com.example.query.Entity.Account;

@RestController
public class AccountQieryCoontroller {
	@Autowired
	QueryGateway gateway;
	public List<Account> getAll( GetAllAccountDto accountDto){
		return gateway.query(accountDto, ResponseTypes.multipleInstancesOf(Account.class)).join();
	}
	public CompletableFuture<Account> getAccountById(GetAccountQueryId getAccountQueryId) {
		return gateway.query(getAccountQueryId, ResponseTypes.instanceOf(Account.class));
	}

}
