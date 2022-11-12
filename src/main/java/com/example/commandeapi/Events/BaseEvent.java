package com.example.commandeapi.Events;

public abstract  class BaseEvent<T> {
	public BaseEvent(T id) {
		
		this.id = id;
	}

	public BaseEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	private T id;

	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}


}
