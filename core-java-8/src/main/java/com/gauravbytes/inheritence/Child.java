package com.gauravbytes.inheritence;

public class Child extends Parent {
	public void myOtherMethod() {
		Child.myStaticMethod();
	}

	public static void myStaticMethod() {
		System.out.println("Child myStatic Method");
	}
}
