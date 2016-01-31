package com.github.scompo.notifer.api.events.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.utils.patterns.observer.Observable;

public abstract class AbstractEventConsumer implements EventConsumer{
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractEventConsumer.class);

	@Override
	public void updateObserver(Observable<Event> observable, Event param) {
		
		logger.debug("called updateObserver with {} , {}", observable, param);
		
		doActionOnEvent(observable, param);
	}

	public abstract void doActionOnEvent(Observable<Event> observable, Event param);
}
