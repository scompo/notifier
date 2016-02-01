package com.github.scompo.notifer.app;

import java.util.Arrays;

import com.github.scompo.notifer.api.NotifierConfiguration;
import com.github.scompo.notifer.api.runners.NotifierRunnerBuilder;
import com.github.scompo.notifer.app.events.consumers.TimerConsumer;
import com.github.scompo.notifer.app.events.producers.CommandLineEventProducer;

public class Application {

	public static void main(String[] args) {

		NotifierRunnerBuilder.with(notifierConfiguration()).build().doStart();
	}

	private static NotifierConfiguration notifierConfiguration() {

		NotifierConfiguration notifierConfiguration = new AllConsumersListenAllProducersNotifierConfiguration(Arrays.asList(new TimerConsumer()),
				Arrays.asList(new CommandLineEventProducer()));

		return notifierConfiguration;
	}

}
