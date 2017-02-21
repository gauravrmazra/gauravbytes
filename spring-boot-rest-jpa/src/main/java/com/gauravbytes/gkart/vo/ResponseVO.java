package com.gauravbytes.gkart.vo;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 * @param <T> of type
 */
public class ResponseVO<T> {
	private T results;
	
	public ResponseVO(T results) {
		this.results = results;
	}
	
	public T getResults() {
		return this.results;
	}
}
