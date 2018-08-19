package com.gauravbytes.elk;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.json.JSONObject;

import com.gauravbytes.elk.event.AppEvent;
import com.gauravbytes.elk.event.AppEvent.AppEventType;
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
	private static final String[] REQUEST_IPS = new String[] { "192.168.1.1", "192.168.4.4", "192.168.5.12",
			"192.168.7.219", "192.168.2.125" };

	private static final String[] IDENTIFIERS = new String[] { "1", "2", "3", "4", "5" };

	private static final AppEventType[] EVENT_TYPES = new AppEventType[] { AppEventType.LOGIN_SUCCESS,
			AppEventType.LOGIN_FAILURE, AppEventType.DATA_READ, AppEventType.DATA_WRITE, AppEventType.ERROR };

	private static final Random RAND = new Random();

	private Throwable getRandomThrowable() {
		return new RuntimeException(ERROR_MESSAGES[RAND.nextInt(3)]);
	}

	public static void main(String[] args) {
		AppEventGenerator dummyEventGenerator = new AppEventGenerator();
		dummyEventGenerator.generateDummyAppEvents();
		dummyEventGenerator.generateDummyAppLogs();
	}

	public void generateDummyAppEvents() {
		EventEmitter<AppEvent> appEventEmitter = getAppEventsEmitter();
		IntStream.range(0, 1000).mapToObj(i -> {
			AppEvent event = AppEvent.of(IDENTIFIERS[RAND.nextInt(5)], "localhost", REQUEST_IPS[RAND.nextInt(5)])
					.eventType(EVENT_TYPES[RAND.nextInt(5)]).apiName("EmployeeApi").message("This is dummy message");
			if (event.getEventType() == AppEventType.ERROR) {
				event.throwable(getRandomThrowable());
			}
			return event;
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
			
			if (Objects.nonNull(appEvent.getThrowable())) {
				StringWriter writer = new StringWriter();
				appEvent.getThrowable().printStackTrace(new PrintWriter(writer));
				appEventJson.put("stacktrace", writer.toString());
			}
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
