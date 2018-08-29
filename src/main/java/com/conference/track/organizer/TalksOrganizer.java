package com.conference.track.organizer;

import java.util.List;
import java.util.Map;

import com.conference.track.domain.Talk;
import com.conference.track.exception.InvalidTalkException;

public interface TalksOrganizer {
	
	public List<Talk> organize(Map<String, Integer> talksMap, int length) throws InvalidTalkException;

}
