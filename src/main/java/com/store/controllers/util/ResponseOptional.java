package com.store.controllers.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResponseOptional<T> {

	private Optional<?> data;
	private List<String> errors;
	private String messages;

	public ResponseOptional() {
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
    public Optional<?> getData() {
    	return data;
    }
	  
    public void setData(Optional<?> data) {
    	this.data = data;
    }

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
    
    

}
