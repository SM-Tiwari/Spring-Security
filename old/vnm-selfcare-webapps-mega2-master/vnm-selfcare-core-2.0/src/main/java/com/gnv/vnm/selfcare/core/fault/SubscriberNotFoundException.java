/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class SubscriberNotFoundException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public SubscriberNotFoundException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SubscriberNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SubscriberNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SubscriberNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SubscriberNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
