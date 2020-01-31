/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class OrderIdNotFoundException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public OrderIdNotFoundException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public OrderIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public OrderIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public OrderIdNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public OrderIdNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
