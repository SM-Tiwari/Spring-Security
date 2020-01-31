/**
 * PasswordMismatchException.java
 */
package com.gnv.vnm.selfcare.core.fault;

/**
 * @author nandipinto
 *
 */
public class TokenExpiredException extends InvalidTokenException {

	private static final long serialVersionUID = 6708531960977655790L;

	public TokenExpiredException() {
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TokenExpiredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TokenExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TokenExpiredException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TokenExpiredException(Throwable cause) {
		super(cause);
	}

	
}
