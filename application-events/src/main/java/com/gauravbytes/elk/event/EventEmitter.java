package com.gauravbytes.elk.event;

/**
 * 
 * @author Gaurav Rai Mazra 
 * {@link https://gauravbytes.com}
 * {@link https://lineofcode.in}
 *
 * @param <T>
 *            type of event
 */
public interface EventEmitter<T extends BaseEvent<T>> {
	public void emit(T event);
}
