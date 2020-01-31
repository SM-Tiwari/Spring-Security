/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class SubscriptionAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public SubscriptionAlreadyExistsException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SubscriptionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SubscriptionAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SubscriptionAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SubscriptionAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	
}
