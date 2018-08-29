package com.conference.track.domain;

public class Event {
	
	private String name;
	private int length;
	private String startTime;
	private String endTime;
	
	public Event(String name, int length) {
		this.name = name;
		this.length = length;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String toString() {
		return "Event: " + "name-" + name + ", length-"+ length + ", start time-" + startTime; 
	}

}
