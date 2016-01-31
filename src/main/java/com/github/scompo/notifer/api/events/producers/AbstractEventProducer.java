package com.github.scompo.notifer.api.events.producers;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.utils.patterns.observer.AbstractObservable;

/**
 * Base class for an {@link EventProducer} implementation.
 */
public abstract class AbstractEventProducer extends AbstractObservable<Event> implements EventProducer {

	@Override
	public String getName() {
		
		return this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return "AbstractEventProducer [getName()=" + getName() + "]";
	}
}
