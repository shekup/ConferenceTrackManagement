package com.conference.track.exception;

public class InvalidTalkException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public InvalidTalkException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
