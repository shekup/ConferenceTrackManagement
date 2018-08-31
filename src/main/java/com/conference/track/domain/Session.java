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
		this.talksList = new ArrayList<Talk>();
		this.length = (sessionType.endTime - sessionType.startTime)*60;
		this.startTime = TimeUtil.timeConverter(sessionType.startTime);
		this.endTime = TimeUtil.timeConverter(sessionType.endTime);
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
	public void setTalksList(List<Talk> talksList) {
		this.talksList = talksList;
		int lenTalks = 0;
		for(Talk talk: talksList) {
			lenTalks = lenTalks + talk.getLength();
		}
		alterSession(lenTalks);
	}
	
	private void alterSession(int sessionLength) {
		this.length = sessionLength;
		String lenTalksStr = TimeUtil.minsToHrs(sessionLength);
		this.endTime = TimeUtil.addTime(lenTalksStr, sessionType.startTime);
	}

	public int getLength() {
		return length;
	}

	public String toString() {
		return sessionType + " session: Start time-" + startTime + " End Time-" + endTime;  
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public SessionType getSessionType() {
		return sessionType;
	}
	
}
