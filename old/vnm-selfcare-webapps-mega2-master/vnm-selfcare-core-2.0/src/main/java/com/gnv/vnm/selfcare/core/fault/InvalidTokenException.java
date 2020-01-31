/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class InvalidTokenException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public InvalidTokenException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidTokenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InvalidTokenException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidTokenException(Throwable cause) {
		super(cause);
	}

	
}
