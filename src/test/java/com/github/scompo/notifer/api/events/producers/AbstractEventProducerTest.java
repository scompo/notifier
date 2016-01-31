package com.github.scompo.notifer.api.events.producers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.notifer.api.events.commons.EventProducerTestImpl;

public class AbstractEventProducerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {

		EventProducer eventProducer = new EventProducerTestImpl();

		assertEquals(eventProducer.getClass().getSimpleName(), eventProducer.getName());
	}

}
