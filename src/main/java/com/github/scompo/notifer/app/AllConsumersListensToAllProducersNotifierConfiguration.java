package com.github.scompo.notifer.app;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scompo.notifer.api.NotifierConfiguration;
import com.github.scompo.notifer.api.events.consumers.EventConsumer;
import com.github.scompo.notifer.api.events.producers.EventProducer;
import com.github.scompo.utils.startable.StartablesHelper;

/**
 * A {@link NotifierConfiguration} where all {@link EventConsumer}s are consumers of all {@link EventProducer}s
 */
public class AllConsumersListensToAllProducersNotifierConfiguration implements NotifierConfiguration {

	private static final Logger logger = LoggerFactory
			.getLogger(AllConsumersListensToAllProducersNotifierConfiguration.class);

	private Collection<EventConsumer> eventConsumers;

	private Collection<EventProducer> eventProducers;

	public AllConsumersListensToAllProducersNotifierConfiguration(Collection<EventConsumer> eventConsumers,
			Collection<EventProducer> eventSources) {

		this.eventConsumers = eventConsumers;
		this.eventProducers = eventSources;
	}

	@Override
	public void doConfiguration() {

		logger.debug("called doConfiguration");

		for (EventProducer eventSource : getEventProducers()) {

			for (EventConsumer eventConsumer : getEventConsumers()) {

				logger.trace("adding consumer: {} to source: {}", eventConsumer, eventSource);
				eventSource.addObserver(eventConsumer);
			}
		}
	}

	@Override
	public void doStart() {

		StartablesHelper.runStartables(getEventConsumers());
		StartablesHelper.runStartables(getEventProducers());
	}

	public Collection<EventConsumer> getEventConsumers() {

		return eventConsumers;
	}

	public void setEventConsumers(Collection<EventConsumer> eventConsumers) {

		this.eventConsumers = eventConsumers;
	}

	public Collection<EventProducer> getEventProducers() {
		return eventProducers;
	}

	public void setEventProducers(Collection<EventProducer> eventProducers) {
		this.eventProducers = eventProducers;
	}
}