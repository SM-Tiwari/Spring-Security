/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class ExternalSubscriberException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public ExternalSubscriberException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ExternalSubscriberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExternalSubscriberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ExternalSubscriberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExternalSubscriberException(Throwable cause) {
		super(cause);
	}

	
}
