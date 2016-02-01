package com.github.scompo.notifer.api.events.producers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.scompo.notifer.api.events.commons.EventProducerTestImpl;

public class AbstractEventProducerTest {

	@Test
	public void testGetName() {

		EventProducer eventProducer = new EventProducerTestImpl();

		assertEquals(eventProducer.getClass().getSimpleName(), eventProducer.getName());
	}

}
