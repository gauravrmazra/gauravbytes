package com.gauravbytes.elk.event;

import java.util.Objects;
import java.util.function.Function;

/**
 * Pojo for application logs
 * @author Gaurav Rai Mazra
 * {@link https://gauravbytes.com}
 * {@link https://lineofcode.in}
 */
public class AppLog implements BaseEvent<AppLog> {
	private String apiName;
	private String message;
	private Throwable throwable;

	public AppLog(String apiName, String message) {
		this.apiName = apiName;
		this.message = message;
	}

	public AppLog(String apiName, String message, Throwable throwable) {
		this(apiName, message);
		this.throwable = throwable;
	}

	public String getApiName() {
		return this.apiName;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public Throwable getThrowable() {
		return this.throwable;
	}

	@Override
	public boolean isErrorLevel() {
		return Objects.nonNull(getThrowable());
	}

	@Override
	public String transform(Function<AppLog, String> transformer) {
		return transformer.apply(this);
	}

}
