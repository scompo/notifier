package com.github.scompo.notifer.api.events.commons;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.consumers.AbstractEventConsumer;
import com.github.scompo.utils.patterns.observer.Observable;

public class EventConsumerTestImpl extends AbstractEventConsumer {

	private boolean calledDoAction = false;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doActionOnEvent(Observable<Event> observable, Event param) {
		
		calledDoAction = true;
	}

	public boolean isCalledDoAction() {
		
		return calledDoAction ;
	}

}
