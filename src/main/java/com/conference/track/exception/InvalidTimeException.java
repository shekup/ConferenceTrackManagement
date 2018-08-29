package com.conference.track.exception;

public class InvalidTimeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public InvalidTimeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
