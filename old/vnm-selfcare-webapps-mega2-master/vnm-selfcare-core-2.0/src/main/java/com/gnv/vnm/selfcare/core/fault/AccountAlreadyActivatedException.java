/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class AccountAlreadyActivatedException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public AccountAlreadyActivatedException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AccountAlreadyActivatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AccountAlreadyActivatedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AccountAlreadyActivatedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AccountAlreadyActivatedException(Throwable cause) {
		super(cause);
	}

	
}
