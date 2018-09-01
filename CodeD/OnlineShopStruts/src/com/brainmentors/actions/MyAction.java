package com.brainmentors.actions;

public class MyAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String sayHello() {
		message = "Hello I am Struts";
		return "success";
	}
	
}
