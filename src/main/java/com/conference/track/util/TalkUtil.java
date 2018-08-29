package com.conference.track.util;

import java.util.regex.Pattern;

import com.conference.track.domain.Talk;
import com.conference.track.exception.InvalidTalkException;

public class TalkUtil {
	
	static final Pattern pattern = Pattern.compile(".*\\D.*");
	
	public static Talk createTalk(String title, int length) throws InvalidTalkException {
		Talk talk = new Talk();
		if((title == null) || (title.equals("")))
			throw new InvalidTalkException("Invalid title length");
		if(!(pattern.matcher(title).matches()))
			throw new InvalidTalkException("Invalid title");
		talk.setTitle(title);
		if(length<5)
			throw new InvalidTalkException("Invalid talk length");
		talk.setLength(length);
		return talk;
	}
	
		
}
