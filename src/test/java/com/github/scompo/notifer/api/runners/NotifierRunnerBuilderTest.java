package com.github.scompo.notifer.api.runners;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.scompo.notifer.api.runners.commons.NotifierConfigurationTestImpl;

public class NotifierRunnerBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
