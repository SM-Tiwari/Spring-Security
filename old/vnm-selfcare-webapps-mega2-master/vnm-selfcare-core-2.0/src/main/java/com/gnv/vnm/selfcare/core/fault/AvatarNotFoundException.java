/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class AvatarNotFoundException extends Exception {

	private static final long serialVersionUID = 6708531960977655790L;

	public AvatarNotFoundException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AvatarNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AvatarNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AvatarNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AvatarNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
