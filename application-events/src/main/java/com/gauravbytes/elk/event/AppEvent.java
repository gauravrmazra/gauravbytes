package com.gauravbytes.elk.event;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.function.Function;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gauravbytes.com}
 * {@link https://lineofcode.in}
 *
 */
public class AppEvent implements BaseEvent<AppEvent> {
	public enum AppEventType {
		LOGIN_SUCCESS, LOGIN_FAILURE, DATA_READ, DATA_WRITE, ERROR;
	}

	private String identifier;
	private String hostAddress;
	private String requestIP;
	private ZonedDateTime eventTime;
	private AppEventType eventType;
	private String apiName;
	private String message;
	private Throwable throwable;

	public AppEvent(String identifier, String hostAddress, String requestIP) {
		this.identifier = identifier;
		this.hostAddress = hostAddress;
		this.requestIP = requestIP;
		this.eventTime = ZonedDateTime.now(Clock.systemUTC());
	}

	public static AppEvent of(String identifier, String hostAddress, String requestIP) {
		return new AppEvent(identifier, hostAddress, requestIP);
	}

	public AppEvent eventType(AppEventType eventType) {
		this.eventType = eventType;
		return this;
	}

	public AppEvent apiName(String apiName) {
		this.apiName = apiName;
		return this;
	}

	public AppEvent throwable(Throwable throwable) {
		this.throwable = throwable;
		return this;
	}

	public AppEvent message(String message) {
		this.message = message;
		return this;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public String getRequestIP() {
		return requestIP;
	}

	public AppEventType getEventType() {
		return eventType;
	}

	public ZonedDateTime getEventTime() {
		return eventTime;
	}

	public String getApiName() {
		return apiName;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AppEvent [identifier=" + identifier + ", hostAddress=" + hostAddress + ", requestIP=" + requestIP
				+ ", eventType=" + eventType + ", eventTime=" + eventTime + ", apiName=" + apiName + ", message="
				+ message + "]";
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
	public String transform(Function<AppEvent, String> transformer) {
		return transformer.apply(this);
	}
}
