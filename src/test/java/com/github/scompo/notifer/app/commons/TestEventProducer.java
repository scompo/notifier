package com.github.scompo.notifer.app.commons;

import com.github.scompo.notifer.api.events.producers.AbstractEventProducer;

public class TestEventProducer extends AbstractEventProducer {
	
	private boolean started = false;

	@Override
	public void doStart() {
		
		started = true;
	}

	public boolean isStarted() {
		return started;
	}
}