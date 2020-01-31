/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class EmailAddressNotRegisteredException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public EmailAddressNotRegisteredException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmailAddressNotRegisteredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmailAddressNotRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public EmailAddressNotRegisteredException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmailAddressNotRegisteredException(Throwable cause) {
		super(cause);
	}

	
}
