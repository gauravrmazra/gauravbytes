package com.gauravbytes.elk.event;

import java.util.function.Function;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gauravbytes.com}
 * {@link https://lineofcode.in}
 *
 * @param <T> type of event
 */
public interface BaseEvent<T> {
	Throwable getThrowable();
	
	boolean isErrorLevel();
	
	public String transform(Function<T, String> transformer);
}
