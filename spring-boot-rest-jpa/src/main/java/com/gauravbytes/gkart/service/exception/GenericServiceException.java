package com.gauravbytes.gkart.service.exception;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
public class GenericServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3681636607322599994L;
	
	public GenericServiceException(String message) {
		super(message);
	}
}
