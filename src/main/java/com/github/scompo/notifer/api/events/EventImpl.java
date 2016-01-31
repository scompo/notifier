package com.github.scompo.notifer.api.events;

import java.time.ZonedDateTime;

/**
 * {@link Event} implementation.
 */
public class EventImpl implements Event{
	
	private ZonedDateTime start;
	
	private String name;
	
	public EventImpl(String name, ZonedDateTime start) {
		
		this.name = name;
		this.start = start;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public ZonedDateTime getStart() {
		return start;
	}

	@Override
	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "EventImpl [start=" + start + ", name=" + name + "]";
	}
}
