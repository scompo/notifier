package com.github.scompo.notifer.app;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.notifer.app.commons.TestEventConsumer;
import com.github.scompo.notifer.app.commons.TestEventProducer;

public class AllConsumersListenAllProducersNotifierConfigurationTest {

	private static final int NUM_PRODUCERS = 10;

	private static final int NUM_CONSUMERS = 10;

	private AllConsumersListenAllProducersNotifierConfiguration testConf;

	private Collection<TestEventProducer> producers;

	private Collection<TestEventConsumer> consumers;

	@Before
	public void setUp() throws Exception {

		producers = getEventProducersTest();

		consumers = getEventConsumersTest();

		testConf = new AllConsumersListenAllProducersNotifierConfiguration(consumers, producers);
	}

	private Collection<TestEventProducer> getEventProducersTest() {

		List<TestEventProducer> producers = new ArrayList<TestEventProducer>();

		for (int i = 0; i < NUM_PRODUCERS; i++) {

			producers.add(new TestEventProducer());
		}

		return producers;
	}

	private Collection<TestEventConsumer> getEventConsumersTest() {

		List<TestEventConsumer> consumers = new ArrayList<TestEventConsumer>();

		for (int i = 0; i < NUM_CONSUMERS; i++) {

			consumers.add(new TestEventConsumer());
		}

		return consumers;
	}

	@After
	public void tearDown() throws Exception {

		testConf = null;
		producers = null;
		consumers = null;
	}

	@Test
	public void testDoConfiguration() {

		testConf.doConfiguration();

		for (TestEventProducer eventProducer : producers) {

			for (TestEventConsumer testEventConsumer : consumers) {

				assertTrue(eventProducer.getObservers().contains(testEventConsumer));
			}
		}
	}

	@Test
	public void testDoStart() {
		
		testConf.doConfiguration();
		testConf.doStart();
		
		consumers.forEach(x -> assertTrue(x.isStarted()));
		producers.forEach(x -> assertTrue(x.isStarted()));
	}

}
