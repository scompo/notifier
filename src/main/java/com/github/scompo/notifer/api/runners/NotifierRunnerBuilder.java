package com.github.scompo.notifer.api.runners;

import com.github.scompo.notifer.api.NotifierConfiguration;

public class NotifierRunnerBuilder {
	
	protected NotifierConfiguration notifierConfiguration;

	private NotifierRunnerBuilder(NotifierConfiguration notifierConfiguration) {
		
		this.notifierConfiguration = notifierConfiguration;
	}

	public static NotifierRunnerBuilder with(NotifierConfiguration notifierConfiguration) {
		
		return new NotifierRunnerBuilder(notifierConfiguration);
	}

	public NotifierRunnerImpl build() {
		
		return new NotifierRunnerImpl(getNotifierConfiguration());
	}

	private NotifierConfiguration getNotifierConfiguration() {
		return notifierConfiguration;
	}

}
