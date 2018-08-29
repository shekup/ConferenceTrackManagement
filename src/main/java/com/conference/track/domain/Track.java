package com.conference.track.domain;

import java.util.List;

import com.conference.track.util.Constants;
import com.conference.track.util.TimeUtil;

/**
 * This class has hard coded rule:
 * Track has two sessions: Morning and Evening
 * Track has lunch break and networking event
 */
public class Track {
	
	private Session morningSession;
	private Session eveningSession;
	private Event lunch;
	private Event networking;
	
	public Track() {
		morningSession = new Session(SessionType.MORNING);
		eveningSession = new Session(SessionType.EVENING);
	}

	public Event getLunch() {
		return lunch;
	}

	public void setLunch(Event lunch) {
		this.lunch = lunch;
	}

	public Event getNetworking() {
		return networking;
	}

	public void setNetworking(Event networking) {
		this.networking = networking;
	}

	public Session getMorningSession() {
		return morningSession;
	}

	public void setMorningSession(Session morningSession) {
		this.morningSession = morningSession;
	}

	public Session getEveningSession() {
		return eveningSession;
	}

	public void setEveningSession(Session eveningSession) {
		this.eveningSession = eveningSession;
	}
	
	/**
	 * The method prints the complete Track in required format.  
	 * Track prints in following sequence:
	 * 1. Morning session
	 * 2. Lunch break
	 * 3. Evening session
	 * 4. Networking event
	 */
	public void printTrackOnConsole() {
		
		// Print Morning Session
		int morSessionTime = (morningSession.getSessionType().startTime)*60;
		List<Talk> morningSessionTalks = morningSession.getTalksList();
		StringBuilder printMorSessionTalk = new StringBuilder(morningSession.getStartTime());
		for(Talk talk: morningSessionTalks) {
			printMorSessionTalk.append(" ").append(talk.getTitle());
			System.out.println(printMorSessionTalk);
			printMorSessionTalk = new StringBuilder("");
			morSessionTime = morSessionTime + talk.getLength();
			printMorSessionTalk.append(TimeUtil.minsToHrs(morSessionTime)).append("AM");
		}
		
		// Print lunch
		System.out.println(Constants.PRINT_LUNCH);
		
		// Print Evening Session
		int eveSessionTime = (eveningSession.getSessionType().startTime - 12)*60;
		List<Talk> eveningSessionTalks = eveningSession.getTalksList();
		StringBuilder printEveSessionTalk = new StringBuilder("");
		printEveSessionTalk.append(eveningSession.getStartTime());
		for(Talk talk: eveningSessionTalks) {
			printEveSessionTalk.append(" ").append(talk.getTitle());
			System.out.println(printEveSessionTalk);
			printEveSessionTalk = new StringBuilder("");
			eveSessionTime = eveSessionTime + talk.getLength();
			printEveSessionTalk.append(TimeUtil.minsToHrs(eveSessionTime)).append("PM");
		}
		
		// Print Networking
		System.out.println(networking.getStartTime() + " " + Constants.EVENT_NETWORKING);
		
	}
	
}
