package com.github.scompo.notifer.api.runners;

import com.github.scompo.notifer.api.NotifierConfiguration;


public class NotifierRunnerImpl implements NotifierRunner {
	
	private NotifierConfiguration notifierConfiguration;
	
	protected NotifierRunnerImpl(NotifierConfiguration notifierConfiguration){
		
		this.notifierConfiguration = notifierConfiguration;
	}

	@Override
	public void doStart() {
		
		getNotifierConfiguration().doConfiguration();
		getNotifierConfiguration().doStart();
	}

	public NotifierConfiguration getNotifierConfiguration() {

		return notifierConfiguration;
	}

	public void setNotifierConfiguration(NotifierConfiguration notifierConfiguration) {

		this.notifierConfiguration = notifierConfiguration;
	}

}
