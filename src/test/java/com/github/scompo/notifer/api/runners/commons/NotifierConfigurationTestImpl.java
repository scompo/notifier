package com.github.scompo.notifer.api.runners.commons;

import com.github.scompo.notifer.api.NotifierConfiguration;

public class NotifierConfigurationTestImpl implements NotifierConfiguration {
	
	private long timeDoStart;

	private long timeDoConfiguration;

	@Override
	public void doStart() {

		timeDoStart = System.nanoTime();
	}

	@Override
	public void doConfiguration() {

		timeDoConfiguration = System.nanoTime();
	}

	public long getTimeDoStart() {
		return timeDoStart;
	}

	public long getTimeDoConfiguration() {
		return timeDoConfiguration;
	}
}
