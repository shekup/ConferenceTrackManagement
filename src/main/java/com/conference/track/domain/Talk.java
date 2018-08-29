package com.conference.track.domain;

public class Talk {
	
	private String title;
	
	private int length;
	
	private String startTime;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String toString() {
		
		return title + " " + length;
	}
	

}
