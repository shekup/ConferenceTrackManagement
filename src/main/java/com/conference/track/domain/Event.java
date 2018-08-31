package com.conference.track.domain;

public class Event {
	
	private String name;
	private int length;
	private String startTime;
	
	public Event(String name, int length) {
		this.name = name;
		this.length = length;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String toString() {
		return "Event: " + "name-" + name + ", length-"+ length + ", start time-" + startTime; 
	}

}
