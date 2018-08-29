package com.conference.track.exception;

public class InvalidInputException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public InvalidInputException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}


}
