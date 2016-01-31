package com.github.scompo.notifer.api.runners.commons;

import java.util.Date;

import com.github.scompo.notifer.api.NotifierConfiguration;

public class NotifierConfigurationTestImpl implements NotifierConfiguration {
	private long timeDoStart;

	private long timeDoConfiguration;

	@Override
	public void doStart() {

		timeDoStart = new Date().getTime();
	}

	@Override
	public void doConfiguration() {

		timeDoConfiguration = new Date().getTime();
	}

	public long getTimeDoStart() {
		return timeDoStart;
	}

	public long getTimeDoConfiguration() {
		return timeDoConfiguration;
	}
}
