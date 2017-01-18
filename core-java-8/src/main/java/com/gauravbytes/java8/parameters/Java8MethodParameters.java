package com.gauravbytes.java8.parameters;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Java8MethodParameters {
	public void dummyMethod(String name, Integer index, int goal) {
		System.out.println("In dummy method");
	}
	
	public static void main(String[] args) {
		Class<Java8MethodParameters> clazz = Java8MethodParameters.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			for (Parameter parameter : method.getParameters()) {
				System.out.println(parameter.getName());
			}
		}
	}
}
