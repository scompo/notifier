package com.github.scompo.notifer.api.runners;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.notifer.api.runners.commons.NotifierConfigurationTestImpl;

public class NotifierRunnerImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoStart() {

		NotifierConfigurationTestImpl notifierConfiguration = new NotifierConfigurationTestImpl();

		NotifierRunnerImpl notifierRunnerImpl = new NotifierRunnerImpl(notifierConfiguration);

		notifierRunnerImpl.doStart();

		assertNotNull(notifierConfiguration.getTimeDoConfiguration());
		assertNotNull(notifierConfiguration.getTimeDoStart());
		assertTrue(notifierConfiguration.getTimeDoConfiguration() < notifierConfiguration.getTimeDoStart());
	}
}
