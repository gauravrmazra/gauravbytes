package com.gauravbytes.java8.functional;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
@FunctionalInterface
public interface Spec<T> {
	boolean isSatisfiedBy(T t);
	
	default Spec<T> not() {
		return (t) -> !isSatisfiedBy(t);
	}
	
	default Spec<T> and(Spec<? super T> other) {
		return (t) -> isSatisfiedBy(t) && other.isSatisfiedBy(t);
	}
	
	default Spec<T> or(Spec<? super T> other) {
		return (t) -> isSatisfiedBy(t) || other.isSatisfiedBy(t);
	}
	
	@Override
	String toString();
}
