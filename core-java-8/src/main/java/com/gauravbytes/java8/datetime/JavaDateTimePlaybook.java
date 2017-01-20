package com.gauravbytes.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class JavaDateTimePlaybook {
	public static void main(String[] args) {
		LocalDateTime todayTime = LocalDateTime.now();
		System.out.println(todayTime);

		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		System.out.println(todayTime.toInstant(ZoneOffset.MAX));
		
		ZonedDateTime dateTime = ZonedDateTime.of(todayTime, ZoneId.of("Europe/Paris"));
		System.out.println(dateTime);
	}
}
