/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class InvalidPasswordFormatException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public InvalidPasswordFormatException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidPasswordFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidPasswordFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InvalidPasswordFormatException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidPasswordFormatException(Throwable cause) {
		super(cause);
	}

	
}
