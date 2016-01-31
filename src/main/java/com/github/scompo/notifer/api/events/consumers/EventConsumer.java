package com.github.scompo.notifer.api.events.consumers;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.utils.names.Named;
import com.github.scompo.utils.patterns.observer.Observer;
import com.github.scompo.utils.startable.Startable;

/**
 * {@link Event} consumer definition.
 * 
 * @author Mauro Scomparin
 */
public interface EventConsumer extends Observer<Event>, Named, Startable{

}
