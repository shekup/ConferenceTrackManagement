package com.conference.track.domain;

public enum SessionType {
	MORNING(9,12), EVENING(13,17);
	
	int startTime;
	int endTime;
	
	SessionType(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String toString() {
		return this.name();
	}

}
