package com.gauravbytes.elk;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.json.JSONObject;

import com.gauravbytes.elk.event.AppEvent;
import com.gauravbytes.elk.event.AppLog;
import com.gauravbytes.elk.event.BaseEvent;
import com.gauravbytes.elk.event.EventEmitter;
import com.gauravbytes.elk.event.LoggerEventEmitter;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gauravbytes.com}
 *         {@link https://lineofcode.in}
 *
 *
 */
public class AppEventGenerator {

	private static final String[] ERROR_MESSAGES = new String[] { "Error Database", "Client exception",
			"Server Exception" };
	
	private static final Random RAND = new Random();

	private Throwable getRandomThrowable() {
		return new RuntimeException(ERROR_MESSAGES[RAND.nextInt(3)]);
	}

	public static void main(String[] args) {

	}

	public void generateDummyAppEvents() {
		EventEmitter<AppEvent> appEventEmitter = getAppEventsEmitter();
		IntStream.range(0, 1000).mapToObj(i -> {
			return AppEvent.of(null, null, null);
		}).forEach(appEventEmitter::emit);
	}

	public void generateDummyAppLogs() {
		final EventEmitter<AppLog> appLogEventEmitter = generateAppLogsEmitter();
		IntStream.range(0, 1000).mapToObj(i -> {
			String apiName = "EmployeeApi";
			String message = "This is message: " + i;
			if (i % 10 == 0)
				return new AppLog(apiName, message, getRandomThrowable());
			else
				return new AppLog(apiName, message);
		}).forEach(appLogEventEmitter::emit);
	}

	private LoggerEventEmitter<AppEvent> getAppEventsEmitter() {
		return getEventEmitter(appEvent -> {
			JSONObject appEventJson = new JSONObject();
			appEventJson.put("identifier", appEvent.getIdentifier());
			appEventJson.put("hostAddress", appEvent.getHostAddress());
			appEventJson.put("requestIP", appEvent.getRequestIP());
			appEventJson.put("eventTime", appEvent.getEventTime().toString());
			appEventJson.put("eventType", appEvent.getEventType().name());
			appEventJson.put("apiName", appEvent.getApiName());
			appEventJson.put("message", appEvent.getMessage());
			return appEventJson.toString();
		}, "AppEvents");
	}

	private LoggerEventEmitter<AppLog> generateAppLogsEmitter() {
		return getEventEmitter(appLog -> {
			JSONObject json = new JSONObject();
			json.put("apiName", appLog.getApiName());
			json.put("message", appLog.getMessage());
			return json.toString();
		}, "GauravBytesLogs");
	}

	private <T extends BaseEvent<T>> LoggerEventEmitter<T> getEventEmitter(Function<T, String> transformer,
			String loggerName) {
		return new LoggerEventEmitter<>(transformer, loggerName);
	}

}
