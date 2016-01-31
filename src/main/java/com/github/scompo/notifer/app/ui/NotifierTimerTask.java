package com.github.scompo.notifer.app.ui;

import java.util.TimerTask;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.producers.EventProducer;

public abstract class NotifierTimerTask extends TimerTask{

	private EventProducer eventSoruce;
	
	private Event event;

	public NotifierTimerTask(EventProducer eventSoruce, Event event) {
		
		this.eventSoruce = eventSoruce;
		this.event = event;
	}

	public EventProducer getEventSoruce() {
		return eventSoruce;
	}

	public void setEventSoruce(EventProducer eventSoruce) {
		this.eventSoruce = eventSoruce;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
