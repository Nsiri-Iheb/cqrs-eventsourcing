package com.example.commande.controllles;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commandeapi.command.CreateAccountCommand;
import com.example.commandeapi.command.CreditAccountCommand;
import com.example.commandeapi.command.DebitAccountCommande;
import com.example.commandeapi.dto.CreateAccountDto;
import com.example.commandeapi.dto.CreditAccountDto;
import com.example.commandeapi.dto.DebitedAccountDto;



@RestController
public class AccountCommandController {
	@Autowired
	CommandGateway commandGateway;
	@Autowired
	CommandBus commandBus;
	@Autowired
	EventStore  eventStore;
	@PostMapping("/add")
	public CompletableFuture<String > CreateAccountCommande( @RequestBody CreateAccountDto accountDto) {
		CompletableFuture<String> commandResponse= commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),accountDto.getIntialBalance(),accountDto.getCurrency()));
	//	commandBus.dispatch(CommandMessage));
		return commandResponse;
		
	}
	@PutMapping("/debit")
	public CompletableFuture<String > DebitedAccountCommande( @RequestBody DebitedAccountDto debitedAccountDto){
		CompletableFuture<String> commandResponse=commandGateway.send(new DebitAccountCommande(debitedAccountDto.getId(),debitedAccountDto.getAmount(),debitedAccountDto.getCurrency()));
		return commandResponse;
	}
	@GetMapping("/ev/{id}")
	public Stream getEvents( @PathVariable("id")  String accountId) {
		return eventStore.readEvents(accountId).asStream();
	}
	@PutMapping("/deb")
	public CompletableFuture<String> CreditAccountCommande( @RequestBody CreditAccountDto accountDto){
		CompletableFuture<String> commandResponse=commandGateway.send(new CreditAccountCommand(accountDto.getId(), accountDto.getAmount(), accountDto.getCurrency()));
		return commandResponse;
	}
	}
