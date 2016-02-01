package com.github.scompo.notifer.app.commons;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.consumers.AbstractEventConsumer;
import com.github.scompo.utils.patterns.observer.Observable;

public class TestEventConsumer extends AbstractEventConsumer {

	private boolean started = false;
	private boolean calledDoActionOnEvent = false;
	
	@Override
	public void doStart() {
		
		started = true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doActionOnEvent(Observable<Event> observable, Event param) {
		
		calledDoActionOnEvent = true;
	}
	
	public boolean isStarted() {
		return started;
	}

	public boolean isCalledDoActionOnEvent() {
		
		return calledDoActionOnEvent;
	}
}