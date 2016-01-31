package com.github.scompo.notifer.api.events.consumer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.scompo.notifer.api.events.commons.EventConsumerTestImpl;

public class AbstractEventConsumerTest {

	@Test
	public void testUpdateObserverShouldCallDoActionOnEvent() {
		
		EventConsumerTestImpl eventConsumer = new EventConsumerTestImpl();
		
		eventConsumer.updateObserver(null, null);
		
		assertTrue(eventConsumer.isCalledDoAction());
	}

}
