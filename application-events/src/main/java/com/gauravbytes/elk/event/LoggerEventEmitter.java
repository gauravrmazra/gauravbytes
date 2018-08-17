package com.gauravbytes.elk.event;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gauravbytes.com}
 * {@link https://lineofcode.in}
 *
 * @param <T> type of event
 */
public class LoggerEventEmitter<T extends BaseEvent<T>> implements EventEmitter<T> {
	private static final Logger logger = LoggerFactory.getLogger("AppEvents");
	private final Function<T, String> transformer;

	public LoggerEventEmitter(final Function<T, String> transformer) {
		this.transformer = transformer;
	}

	@Override
	public void emit(T event) {
		String message = event.transform(transformer);

		if (event.isErrorLevel())
			logger.error(message, event.getThrowable());
		else
			logger.info(message);
	}

}
