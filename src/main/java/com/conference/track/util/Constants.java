package com.conference.track.util;

public class Constants {
	
	private Constants() {
		
	}
	
	public static final String INPUT_PATTERN = "^(.+)\\s(\\d+)?\\s?((min)|(lightning))$";
	public static final String TALK_LENGTH_TYPE_LIGHT = "lightning";
	public static final String TALK_LENGTH_TYPE_NORMAL = "min";
	
	//Events
	public static final String EVENT_LUNCH_BREAK = "Lunch";
	public static final int EVENT_LUNCH_LENGTH = 60;
	public static final String EVENT_LUNCH_START_TIME = "12:00PM";
	public static final String EVENT_NETWORKING = "Networking";
	public static final int EVENT_NETWORKING_LENGTH = 60;

	// Sessions
	public static final String SESSION_TYPE_MORNING = "Morning";
	public static final String SESSION_TYPE_EVENING = "Evening";
	
	// Print
	public static final String PRINT_LUNCH = "12:00PM Lunch";
}
