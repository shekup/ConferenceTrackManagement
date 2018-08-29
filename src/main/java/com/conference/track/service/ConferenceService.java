package com.conference.track.service;

import java.util.ArrayList;
import java.util.List;

import com.conference.track.domain.Track;
import com.conference.track.organizer.FIFOTalksOrganizer;
import com.conference.track.organizer.TalksOrganizer;
import com.conference.track.organizer.TrackOrganizer;
import com.conference.track.util.Parser;

/**
 * Factory class to create tracks
 * @author abhishek
 *
 */
public class ConferenceService {
	
	public List<Track> createTacksFromInput(String file) throws Exception{
		
		List<Track> trackList = new ArrayList<Track>();
		System.out.println();
		System.out.println("***************Input***************");
		Parser.parseInput(file);
		
		TalksOrganizer organizer = new FIFOTalksOrganizer();
		TrackOrganizer trackOrganizer = new TrackOrganizer(organizer);
		Track track = trackOrganizer.createTrack(Parser.talksmap);
		System.out.println();
		System.out.println("***************Track***************");
		track.printTrackOnConsole();
		trackList.add(track);
		
		return trackList;
	}

}
