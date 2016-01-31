package com.github.scompo.notifer.api.events.producers;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.utils.names.Named;
import com.github.scompo.utils.patterns.observer.Observable;
import com.github.scompo.utils.startable.Startable;

/**
 *	{@link EventProducer} definition.
 */
public interface EventProducer extends Observable<Event>, Named, Startable{

}
