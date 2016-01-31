package com.github.scompo.notifer.app.events.consumers;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.consumers.AbstractEventConsumer;
import com.github.scompo.notifer.api.events.consumers.EventConsumer;
import com.github.scompo.notifer.api.events.producers.EventProducer;
import com.github.scompo.notifer.app.ui.PopupTimerTask;
import com.github.scompo.utils.patterns.observer.Observable;

/**
 * {@link EventConsumer} implementation with a {@link Timer} that creates {@link PopupTimerTask}s for each event.
 */
public class TimerConsumer extends AbstractEventConsumer implements EventConsumer {

	private static final Logger logger = LoggerFactory.getLogger(TimerConsumer.class);

	private static final String TIMER_NAME = "notifierTimer";

	private static final boolean TIMER_IS_DAEMON = true;

	private Timer timer;

	public static Date getTime(Event event) {

		logger.debug("called getTime with event={}", event);

		return Date.from(event.getStart().toInstant());
	}

	public static TimerTask createTimerTask(EventProducer eventSource, Event event) {

		logger.debug("called createTimerTask with eventSource={} event={}", eventSource, event);

		return new PopupTimerTask(eventSource, event);
	}

	private static Timer initTimer(String timerName, boolean timerIsDaemon) {

		logger.debug("called initTimer with timerName={}, timerIsDaemon={}", timerName, timerIsDaemon);

		return new Timer(timerName, timerIsDaemon);
	}

	public void scheduleTask(Timer timer, Event param, EventProducer eventSource) {

		logger.debug("called scheduleTask with timer={} param={} , eventSource={}", timer, param, eventSource);

		TimerTask timerTask = createTimerTask(eventSource, param);

		Date time = getTime(param);

		timer.schedule(timerTask, time);
	}

	@Override
	public String getName() {

		return getClass().getSimpleName();
	}

	@Override
	public void doStart() {

		timer = initTimer(TIMER_NAME, TIMER_IS_DAEMON);
	}

	@Override
	public String toString() {
		return "TimerConsumer [getName()=" + getName() + "]";
	}

	@Override
	public void doActionOnEvent(Observable<Event> observable, Event param) {

		EventProducer eventSource = (EventProducer) observable;

		scheduleTask(timer, param, eventSource);
	}

}
