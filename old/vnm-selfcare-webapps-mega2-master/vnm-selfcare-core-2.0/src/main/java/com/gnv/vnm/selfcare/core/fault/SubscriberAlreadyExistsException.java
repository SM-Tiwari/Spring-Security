/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class SubscriberAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public SubscriberAlreadyExistsException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SubscriberAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SubscriberAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SubscriberAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SubscriberAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	
}
