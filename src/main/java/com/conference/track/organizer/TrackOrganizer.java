package com.conference.track.organizer;

import java.util.List;
import java.util.Map;

import com.conference.track.domain.Event;
import com.conference.track.domain.Session;
import com.conference.track.domain.Talk;
import com.conference.track.domain.Track;
import com.conference.track.exception.InvalidTalkException;
import com.conference.track.util.Constants;
import com.conference.track.util.TimeUtil;

/**
 * Testing and debugging code that does lots of things is difficult.
 * Write code that doesn't do lots of things. Write each function so that it does one thing and only one thing. 
 * This makes them easy to test with a unit test 
 * It is OK to wrap all smaller methods in one public facing method
 * 
 * @author abhishek
 *
 */
public class TrackOrganizer {
	
	TalksOrganizer organizer;
	Track track;
	Session morningSession;
	Session eveningSession;
	Map<String, Integer> talksMap;
	List<Talk> talksList;
	
	public TrackOrganizer(TalksOrganizer organizer) {
		this.organizer = organizer;
	}
	
	public Track createTrack(Map<String, Integer> talksMap) throws InvalidTalkException {
		track = new Track();
		this.talksMap = talksMap;
		
		// Prepare Morning session
		createMorningSession();
		
		
		// Remove the talks selected for morning session from available list
		for(Talk talk: talksList) {
			String talkTitle = talk.getTitle();
			talksMap.remove(talkTitle);
		}
		
		// Prepare Evening session
		createEveningSession();
		
		// Prepare lunch
		track.setLunch(createLunchEvent());
		
		// Prepare Networking
		track.setNetworking(createNetworkingEvent(track.getEveningSession().getEndTime()));
		
		return track;
	}
	
	private void createMorningSession() throws InvalidTalkException {
		morningSession = track.getMorningSession();
		talksList = organizer.organize(talksMap, morningSession.getLength());
		morningSession.setTalksList(talksList);
		track.setMorningSession(morningSession);
	}
	
	private void createEveningSession() throws InvalidTalkException {
		eveningSession = track.getEveningSession();
		talksList = organizer.organize(talksMap, eveningSession.getLength());
		eveningSession.setTalksList(talksList);
		track.setEveningSession(eveningSession);
	}
	
	Event createLunchEvent() {
		Event lunch = new Event(Constants.EVENT_LUNCH_BREAK, Constants.EVENT_LUNCH_LENGTH);
		lunch.setStartTime(Constants.EVENT_LUNCH_START_TIME);
		return lunch;
	}
	
	Event createNetworkingEvent(String eveSessionEndTime) {
		Event networking = new Event(Constants.EVENT_NETWORKING, Constants.EVENT_NETWORKING_LENGTH);
		networking.setStartTime(TimeUtil.getStartTimeForNetworking(eveSessionEndTime));
		return networking;
	}

}
