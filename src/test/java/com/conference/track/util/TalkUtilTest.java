package com.conference.track.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conference.track.domain.Talk;
import com.conference.track.exception.InvalidTalkException;

public class TalkUtilTest {

	@Test
	public void createTalk_titleAndLengthGiven_Talk() {
		try {
			Talk talk = TalkUtil.createTalk("title", 60);
			assertNotNull(talk);
			assertEquals("title", talk.getTitle());
			assertEquals(60, talk.getLength());
		} catch (InvalidTalkException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test(expected = InvalidTalkException.class)
	public void createTalk_invalidTitleGiven_exceptionThrown() throws InvalidTalkException {
		TalkUtil.createTalk("", 60);
	}

}
