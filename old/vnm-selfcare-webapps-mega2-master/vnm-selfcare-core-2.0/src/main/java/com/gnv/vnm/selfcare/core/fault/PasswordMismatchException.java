/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class PasswordMismatchException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public PasswordMismatchException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PasswordMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PasswordMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PasswordMismatchException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PasswordMismatchException(Throwable cause) {
		super(cause);
	}

	
}
