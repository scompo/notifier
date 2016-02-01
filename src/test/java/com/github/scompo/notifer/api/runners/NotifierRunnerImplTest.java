package com.github.scompo.notifer.api.runners;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.scompo.notifer.api.runners.commons.NotifierConfigurationTestImpl;

public class NotifierRunnerImplTest {

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
