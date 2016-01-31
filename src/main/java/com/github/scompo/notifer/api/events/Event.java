package com.github.scompo.notifer.api.events;

import java.time.ZonedDateTime;

import com.github.scompo.utils.names.Named;

/**
 * {@link Event} definition.
 */
public interface Event extends Named {

	ZonedDateTime getStart();

	public abstract void setStart(ZonedDateTime start);

}
