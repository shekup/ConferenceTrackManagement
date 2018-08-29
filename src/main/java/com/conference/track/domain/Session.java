package com.conference.track.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.conference.track.exception.InvalidTimeException;
import com.conference.track.util.TimeUtil;

public class Session {
	
	private SessionType sessionType;
	
	private String startTime;
	
	private String endTime;
	
	private Date startDateTime;
	
	private Date endDateTime;
	
	private List<Talk> talksList;
	
	private int length;
	
	public Session(SessionType sessionType){
		this.sessionType = sessionType;
		talksList = new ArrayList<Talk>();
		length = (sessionType.endTime - sessionType.startTime)*60;
		startTime = TimeUtil.timeConverter(sessionType.startTime);
		endTime = TimeUtil.timeConverter(sessionType.endTime);
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public List<Talk> getTalksList() {
		return talksList;
	}

	/**
	 * This method adds the talks list to session
	 * Method recalculates the End time of session
	 * 
	 * @param talksList
	 * @throws InvalidTimeException
	 */
	public void setTalksList(List<Talk> talksList) throws InvalidTimeException {
		this.talksList = talksList;
		int lenTalks = 0;
		for(Talk talk: talksList) {
			lenTalks = lenTalks + talk.getLength();
		}
		this.setLength(lenTalks);
		//System.out.println("Length of session calculated is: " + lenTalks + " mins");
		String lenTalksStr = TimeUtil.minsToHrs(lenTalks);
		endTime = TimeUtil.addTime(lenTalksStr, sessionType.startTime);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String toString() {
		return sessionType + " session: Start time-" + startTime + " End Time-" + endTime;  
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public SessionType getSessionType() {
		return sessionType;
	}
	
}
