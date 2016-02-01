package com.github.scompo.notifer.api.runners;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.github.scompo.notifer.api.runners.commons.NotifierConfigurationTestImpl;

public class NotifierRunnerBuilderTest {

	@Test
	public void testWith() {

		NotifierConfigurationTestImpl notifierConfiguration = new NotifierConfigurationTestImpl();

		assertEquals(notifierConfiguration, NotifierRunnerBuilder.with(notifierConfiguration).notifierConfiguration);
	}

	@Test
	public void testBuild() {

		NotifierConfigurationTestImpl notifierConfiguration = new NotifierConfigurationTestImpl();

		NotifierRunnerImpl res = NotifierRunnerBuilder.with(notifierConfiguration).build();

		assertNotNull(res);

		assertEquals(notifierConfiguration, res.getNotifierConfiguration());
	}
}
