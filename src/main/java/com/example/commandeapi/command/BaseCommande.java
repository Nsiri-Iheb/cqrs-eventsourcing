package com.example.commandeapi.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public   abstract class BaseCommande<T> {
	@TargetAggregateIdentifier
	private T id;
	 public BaseCommande(T id){
		this.id=id;
	}
	 public T getId() {
		return id;
	}

}
