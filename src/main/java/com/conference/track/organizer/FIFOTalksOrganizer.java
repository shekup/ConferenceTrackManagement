package com.conference.track.organizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.conference.track.domain.Talk;
import com.conference.track.exception.InvalidTalkException;

public class FIFOTalksOrganizer implements TalksOrganizer{

	public List<Talk> organize(Map<String, Integer> talksMap, int length) throws InvalidTalkException {
		
		List<Talk> talksList = new ArrayList<Talk>();
		
		for(Map.Entry<String, Integer> entry: talksMap.entrySet()) {
			if(entry.getValue()<=length) {
				Talk talk = new Talk(entry.getKey(), entry.getValue());
				talksList.add(talk);
				length = length - entry.getValue();
			}
			if(length<=5)
				break;
		}
		
		return talksList;
	}
	
	

}
