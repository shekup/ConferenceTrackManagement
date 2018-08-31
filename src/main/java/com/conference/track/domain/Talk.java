package com.conference.track.domain;

import java.util.regex.Pattern;

import com.conference.track.exception.InvalidTalkException;

public class Talk {
	
	static final Pattern pattern = Pattern.compile(".*\\D.*");
	
	private String title;
	
	private int length;
	
	private String startTime;
	
	public Talk(String title, int length) throws InvalidTalkException{
		if((title == null) || (title.equals("")))
			throw new InvalidTalkException("Invalid title length");
		if(!(pattern.matcher(title).matches()))
			throw new InvalidTalkException("Invalid title");
		this.title = title;
		if(length<5)
			throw new InvalidTalkException("Invalid talk length");
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public String getStartTime() {
		return startTime;
	}

	public String toString() {
		return title + " " + length;
	}
	

}
